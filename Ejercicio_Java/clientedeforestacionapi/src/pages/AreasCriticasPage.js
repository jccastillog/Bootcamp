import {useEffect, useState} from "react"
import {Button, Container, Modal} from 'react-bootstrap';
import areasCriticasService from "../services/areasCriticasService"
import AreasCriticasTable from "../components/AreasCriticasTable";
import { useNavigate } from "react-router-dom";
import ConfirmacionModal from "../components/ConfirmacionModal";
import AreasCriticasForm from "../components/AreasCriticasForm";


function AreasCriticasPage(){

    const [areasCriticas,setAreasCriticas] = useState([])
    const [showModal, setShowModal] = useState(false)
    const [showConfirmModal, setShowConfirmModal] = useState(false)
    const [areaIdEliminar, setAreaIdEliminar] = useState(null)
    const [selectedArea, setSelectedArea] = useState({nombre:"", descripcion:"",latitud:"",longitud:""})
    const [errors, setErrors] = useState({})
    const navigate = useNavigate()


    const cargarAreasCriticas = async() =>{
        try {
            const response = await areasCriticasService.get()
            setAreasCriticas(response.data)
        } catch (error) {
            console.log("Error al obtener las aréas críticas", error)
        }
    }

    useEffect(()=>{
        cargarAreasCriticas()
    },[])

    const verDetalle = (id) => {
        navigate(`/areas-criticas/${id}`)
    }
    
    const handleShow = (area={nombre:"", descripcion:"",latitud:"",longitud:""}) => {
        setSelectedArea(area)
        setErrors({})
        setShowModal(true)
    }
    const handleClose = () => {setShowModal(false)}

    const handleDelete = (id) => {
            setAreaIdEliminar(id)
            setShowConfirmModal(true)
        }

    const handleConfirm = async () => {
        try {
            await areasCriticasService.eliminar(areaIdEliminar)  //se usa el servicio creado con el parametro de id
            cargarAreasCriticas()  //Se llama a esta función despues de eliminar para ver los cambios
        } catch (error) {
            console.log("Error al eliminar el area crítica",error)
        }
        setShowConfirmModal(false)  //se usa para cerrar el modal despues de la acción
        }

    const handleSave = async () => {
        if(!validarFormulario){
            return
        }
        try {
            if(selectedArea.id){
                await areasCriticasService.actualizar(selectedArea.id,selectedArea)
            }else{
                await areasCriticasService.crear(selectedArea)
            }

            cargarAreasCriticas()

        } catch (error) {
            console.log("Error al guardar el area crítica",error)
        }

        setShowModal(false)

    }

    const validarFormulario = () => {   //En este componente van las validaciones que se hacen al formulario
        const nuevosErrores = {}
        if(selectedArea.nombre.length<2 || selectedArea.nombre.length>100){
            nuevosErrores.nombre = "El nombre debe tener entre 2 y 100 caracteres"
        }
        if(selectedArea.descripcion.length<10 || selectedArea.descripcion.length>500){
            nuevosErrores.descripcion = "La descripción debe tener entre 10 y 500 caracteres"
        }
        if(selectedArea.latitud ==="" || isNaN(selectedArea.latitud)){
            nuevosErrores.latitud = "La latitud no puede estar vacia"
        }
        if(selectedArea.longitud ==="" || isNaN(selectedArea.longitud)){
            nuevosErrores.longitud = "La longitud no puede estar vacia"
        }

        setErrors(nuevosErrores)

        return Object.keys(nuevosErrores).length === 0
    }

    return(
        <Container className="mt-3">
            <h1>Areas críticas</h1>
            <Button variant="primary" className="mb-1" onClick={()=>handleShow()}>Crear área crítica</Button>
            <AreasCriticasTable 
                areasCriticas={areasCriticas}
                verDetalle={verDetalle}
                handleShow={handleShow}
                handleDelete={handleDelete}
            />

            <ConfirmacionModal 
                showConfirmModal= {showConfirmModal}
                handleClose={()=>setShowConfirmModal(false)}  //Se puede enviar una funcion como parametro, pero es mejor crearla y enviarla para mas control del código
                handleConfirm={handleConfirm}
                mensaje="Esta seguro de eliminar el registro?"
            />

            <Modal show={showModal} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>{selectedArea.id ? "Editar área crítica"  : "Crear área crítica"}</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <AreasCriticasForm 
                    area={selectedArea}
                    setArea={setSelectedArea}
                    errors={errors}
                    handleSave={handleSave}
                    />
                </Modal.Body>
            </Modal>

            


        </Container>

    )
}

export default AreasCriticasPage;
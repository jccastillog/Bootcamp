import {useEffect, useState} from "react"
import {Button, Container, Modal} from 'react-bootstrap';
import areasCriticasService from "../services/areasCriticasService"
import AreasCriticasTable from "../components/AreasCriticasTable";
import { useNavigate } from "react-router-dom";
import ConfirmacionModal from "../components/ConfirmacionModal";


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
        showConfirmModal(false)  //se usa para cerrar el modal despues de la acción
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
                    <Modal.Title>Confirmación</Modal.Title>
                </Modal.Header>
                <Modal.Body>Formulario</Modal.Body>
            </Modal>


        </Container>

    )
}

export default AreasCriticasPage;
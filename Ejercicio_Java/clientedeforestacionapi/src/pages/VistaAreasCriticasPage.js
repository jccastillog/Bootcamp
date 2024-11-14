import {useEffect, useState} from "react"
import Table from 'react-bootstrap/Table';
import {Container} from 'react-bootstrap';
import vistaAreasCriticasService from "../services/vistaAreasCriticasService";


function VistaAreasCriticasPage(){

    const [vistaAreasCriticas,setVistaAreasCriticas] = useState([])
    const cargarVistaAreasCriticas = async() =>{
        try {
            const response = await vistaAreasCriticasService.getVistaAreasCriticas()
            setVistaAreasCriticas(response.data)
        } catch (error) {
            console.log("Error al obtener la vista de aréas críticas", error)
        }
    }

    useEffect(()=>{
        cargarVistaAreasCriticas()
    },[])

    return(
        <Container className="mt-3">
            <h1>Vista de áreas críticas</h1>
            <Table striped bordered hover>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Número Evaluaciones</th>
                    </tr>
                </thead>
                <tbody>
                    {vistaAreasCriticas.map(vista=>(
                        <tr key={vista.id}>
                            <td>{vista.id}</td>
                            <td>{vista.nombre}</td>
                            <td>{vista.descripcion}</td>
                            <td>{vista.numeroEvaluaciones}</td>
                        </tr>
                    ))}
                </tbody>
            </Table>

        </Container>
/*         <>
            {vistaAreasCriticas.map((vista=>(vista.nombre)))}
        </> */

    )
}

export default VistaAreasCriticasPage;
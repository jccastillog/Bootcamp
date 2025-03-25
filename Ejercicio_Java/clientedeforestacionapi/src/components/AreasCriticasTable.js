import {Table, Button} from "react-bootstrap";

function AreasCriticasTable({areasCriticas,verDetalle,handleShow,handleDelete}) {
    return (
    <Table striped bordered hover>
        <thead>
        <tr>
            <th>Id</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Latitud</th>
            <th>Longitud</th>
            <th colSpan={2}>Acciones</th>
        </tr>
        </thead>
        <tbody>
            {areasCriticas.map(area =>(
                <tr key = {area.id} onClick={()=>verDetalle(area.id)}>
                    <td>{area.id}</td>
                    <td>{area.nombre}</td>
                    <td>{area.descripcion}</td>
                    <td>{area.latitud}</td>
                    <td>{area.longitud}</td>
                    <td>
                        <Button variant="warning" size="sm" onClick={e=>{e.stopPropagation();handleShow(area)}}>
                            Editar
                        </Button>
                    </td>
                    <td>
                        <Button variant="danger" size="sm" onClick={e=>{e.stopPropagation();handleDelete(area.id)}}>
                            Eliminar
                        </Button>
                    </td>
                </tr>
            ))}
        </tbody>
    </Table>
    );
}

export default AreasCriticasTable;

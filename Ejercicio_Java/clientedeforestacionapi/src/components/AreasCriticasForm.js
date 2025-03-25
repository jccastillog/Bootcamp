import Button from "react-bootstrap/Button";
import Form from "react-bootstrap/Form";


function AreasCriticasForm({area,setArea,errors,handleSave}) {

    console.log(area,setArea,errors,handleSave)
    const handleChange = (e) => {
        const {name,value} = e.target
        setArea(prevState => ({...prevState,[name]:value}))

    }

    return (
        <Form>
            <Form.Group className="mb-3" >
                <Form.Label>Nombre</Form.Label>
                <Form.Control 
                    type="text" 
                    name="nombre"
                    placeholder="Nombre área crítica" 
                    value={area.nombre}
                    onChange={handleChange}
                    isInvalid={errors.nombre}
                />
                <Form.Control.Feedback type="invalid">
                    {errors.nombre}
                </Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3" >
                <Form.Label>Descripción</Form.Label>
                <Form.Control 
                    type="text" 
                    as="textarea"
                    rows={3}
                    name="descripcion"
                    placeholder="Descripción área crítica" 
                    value={area.descripcion}
                    onChange={handleChange}
                    isInvalid={!!errors.descripcion}
                />
                <Form.Control.Feedback type="invalid">
                    {errors.descripcion}
                </Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3" >
                <Form.Label>Latitud</Form.Label>
                <Form.Control 
                    type="number" 
                    name="latitud"
                    placeholder="Latitud área crítica" 
                    value={area.latitud}
                    onChange={handleChange}
                    isInvalid={!!errors.latitud}
                />
                <Form.Control.Feedback type="invalid">
                    {errors.latitud}
                </Form.Control.Feedback>
            </Form.Group>

            <Form.Group className="mb-3" >
                <Form.Label>Longitud</Form.Label>
                <Form.Control 
                    type="number" 
                    name="longitud"
                    placeholder="Longitud área crítica" 
                    value={area.longitud}
                    onChange={handleChange}
                    isInvalid={!!errors.longitud}
                />
                <Form.Control.Feedback type="invalid">
                    {errors.longitud}
                </Form.Control.Feedback>
            </Form.Group>

            <Button variant="outline-primary" onClick={handleSave}>
                Guardar
            </Button>
            </Form>
    );
}

export default AreasCriticasForm;

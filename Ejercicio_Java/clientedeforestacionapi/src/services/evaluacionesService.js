import axios from "axios";

const API_URL = "http://localhost:8080/api/evaluaciones-ferroviarias"

const get = () => axios.get(API_URL)
const getPorID = (id) => axios.get(`${API_URL}/${id}`)
const crear = (data) => axios.post(API_URL,data)
const actualizar = (id,data) => axios.put(`${API_URL}/${id}`,data)
const eliminar = (id) => axios.delete(`${API_URL}/${id}`)
const insertar = (data) => axios.post(`${API_URL}/insertar`,data)


const evaluacionesService = {
    get,
    getPorID,
    crear,
    actualizar,
    eliminar,
    insertar
}

export default evaluacionesService;
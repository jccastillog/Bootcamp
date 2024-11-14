import axios from "axios";

const API_URL = "http://localhost:8080/api/areas-criticas"

const get = () => axios.get(API_URL)
const getPorID = (id) => axios.get(`${API_URL}/${id}`)
const crear = (data) => axios.post(API_URL,data)
const actualizar = (id,data) => axios.put(`${API_URL}/${id}`,data)
const eliminar = (id) => axios.delete(`${API_URL}/${id}`)


const areasCriticasService = {
    get,
    getPorID,
    crear,
    actualizar,
    eliminar
}

export default areasCriticasService;
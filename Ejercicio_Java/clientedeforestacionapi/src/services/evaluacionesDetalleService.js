import axios from "axios";

const API_URL = "http://localhost:8080/api/evaluaciones-ferroviarias"

const getEvaluacionesFerroviarias = () => axios.get(API_URL)
const getEvaluacionesFerroviariasPorID = (id) => axios.get(`${API_URL}/${id}`)
const postEvaluacionesFerroviarias = (data) => axios.post(API_URL,data)
const putEvaluacionesFerroviarias = (id,data) => axios.put(`${API_URL}/${id}`,data)
const deleteEvaluacionesFerroviarias = (id) => axios.delete(`${API_URL}/${id}`)


const vistaEvaluacionesService = {
    getEvaluacionesFerroviarias,
    getEvaluacionesFerroviariasPorID,
    postEvaluacionesFerroviarias,
    putEvaluacionesFerroviarias,
    deleteEvaluacionesFerroviarias
}

export default vistaEvaluacionesService;
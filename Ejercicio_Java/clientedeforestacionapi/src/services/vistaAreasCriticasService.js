import axios from "axios";

const API_URL = "http://localhost:8080/api/vista-areas-criticas"

const getVistaAreasCriticas = () => axios.get(API_URL)

const vistaAreasCriticasService = {
    getVistaAreasCriticas
}

export default vistaAreasCriticasService;
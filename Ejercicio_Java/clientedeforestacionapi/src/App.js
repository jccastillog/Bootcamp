//import './css/App.css';
import 'bootstrap/dist/css/bootstrap.min.css'
import {Container} from 'react-bootstrap';
import React from 'react';
import {BrowserRouter, Routes, Route} from 'react-router-dom';
import AppNavbar from './layouts/AppNavbar';
import VistaAreasCriticasPage from './pages/VistaAreasCriticasPage';
import AreasCriticasPage from './pages/AreasCriticasPage';
import EvaluacionesPage from './pages/EvaluacionesPage';
import AreasCriticasDetallePage from './pages/AreasCriticasDetallePage';
import EvaluacionesDetallePage from './pages/EvaluacionesDetallePage';



function App() {
  return (

    <BrowserRouter>
      <AppNavbar />
      <Container className='mt-4'> 
        <Routes>
          <Route path="/" element={<VistaAreasCriticasPage/>} />
          <Route path="/areas-criticas" element={<AreasCriticasPage/>} />
          <Route path="/evaluaciones" element={<EvaluacionesPage/>} />
          <Route path="/areas-criticas/:id" element={<EvaluacionesDetallePage/>} />
          <Route path="/evaluaciones-detalle/:id" element={<AreasCriticasDetallePage/>} />
        </Routes>
      </Container>
    </BrowserRouter> 
  );
}

export default App;

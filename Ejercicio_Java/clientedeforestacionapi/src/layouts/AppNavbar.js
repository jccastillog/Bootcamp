import Container from 'react-bootstrap/Container';
import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import { Link, useLocation } from 'react-router-dom';


function AppNavbar() {
    const location = useLocation()
  return (
    <Navbar expand="lg" bg='dark' variant='dark'>
      <Container>
        <Navbar.Brand as={Link} to="/">Deforestación</Navbar.Brand>
        <Navbar.Toggle aria-controls="basic-navbar-nav" />
        <Navbar.Collapse id="basic-navbar-nav">
          <Nav className="me-auto">
            <Nav.Link as={Link} to="/areas-criticas" className={location.pathname==="/areas-criticas" ? "active" : ""}>Areas Críticas</Nav.Link>
            <Nav.Link as={Link} to="/evaluaciones" className={location.pathname==="/evaluaciones" ? "active" : ""}>Evaluaciones</Nav.Link>
          </Nav>
        </Navbar.Collapse>
      </Container>
    </Navbar>
  );
}

export default AppNavbar;
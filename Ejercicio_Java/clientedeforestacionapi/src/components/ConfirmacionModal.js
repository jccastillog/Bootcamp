import Button from "react-bootstrap/Button";
import Modal from "react-bootstrap/Modal";

function ConfirmacionModal({showConfirmModal,handleClose,handleConfirm,mensaje}) {
    return (
        <Modal show={showConfirmModal} onHide={handleClose}>
            <Modal.Header closeButton>
                <Modal.Title>Confirmación</Modal.Title>
            </Modal.Header>
            <Modal.Body>{mensaje}</Modal.Body>
            <Modal.Footer>
                <Button variant="secondary" onClick={handleClose}>
                    Cancelar
                </Button>
                {" "}
                <Button variant="primary" onClick={handleConfirm}>
                    Confirmar
                </Button>
            </Modal.Footer>
        </Modal>
    );
}

export default ConfirmacionModal;

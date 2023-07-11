import {ModalPadrao} from "../../../../components/Modal/ModalPadrao";
import {Typography} from "@mui/material";
import {useNavigate} from "react-router-dom";

interface ModalCancelarProps {
  open: boolean;
  onClose: () => void;
  paginaInicial: string;
}

export function ModalCancelar({open, onClose, paginaInicial}: ModalCancelarProps) {
  const navigate = useNavigate()

  return (
    <ModalPadrao
      title={'Cancelar cadastro de perfil'}
      open={open}
      onClose={onClose}
      content={
        <Typography>Caso cancele o cadastro do perfil as informações serão perdidas.</Typography>
      }
      handleConfirm={() => {
        navigate(paginaInicial)
      }}
     />
  );
}
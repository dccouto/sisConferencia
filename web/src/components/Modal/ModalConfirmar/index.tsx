import { Typography } from '@mui/material'
import { ModalPadrao } from '../ModalPadrao'

interface ModalConfirmarProps {
    title: string
    open: boolean
    textOK: string
    textCancel: string
    onClose: (st: boolean) => void
}

function ModalConfirmar({ title, textOK, textCancel, open, onClose }: ModalConfirmarProps) {
    return (
        <ModalPadrao
            onClose={() => onClose(false)}
            open={open}
            title={title}
            content={<Typography>Deseja realmente excluir esta emergência?</Typography>}
            handleConfirm={() => {
                onClose(true)
            }}
            confirmButtonText={textOK}
            cancelButtonText={textCancel}
        />
    )
}

ModalConfirmar.defaultProps = {
    title: 'Confirmar',
    textOK: 'Sim',
    textCancel: 'Cancelar',
    open: false,
    onClose: () => null,
}

export { ModalConfirmar }

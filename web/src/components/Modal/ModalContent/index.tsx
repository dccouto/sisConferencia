import { DialogActions, DialogContent, Dialog, DialogTitle, Button } from '@mui/material'
import { ReactNode } from 'react'

interface ModalPadraoProps {
    open: boolean
    onClose: () => void
    title: string | ReactNode
    children: ReactNode
}

export function ModalContent({ open, onClose, title, children }: ModalPadraoProps) {
    return (
        <Dialog
            open={open}
            onClose={onClose}
            fullWidth={true}
            maxWidth={'md'}
            aria-labelledby='alert-dialog-title'
            aria-describedby='alert-dialog-description'
            sx={{
                height: '85%',
            }}
        >
            <DialogTitle id='alert-dialog-title'>{title}</DialogTitle>
            <DialogContent>{children}</DialogContent>
            <DialogActions
                sx={{
                    backgroundColor: '#F0EEEE',
                    paddingRight: 3,
                }}
            >
                <Button color='secondary' variant='contained' onClick={onClose}>
                    Confirmar
                </Button>
            </DialogActions>
        </Dialog>
    )
}

import { ReactNode } from 'react'
import { Dialog, DialogActions, DialogContent, DialogTitle, Grid, IconButton, Typography } from '@mui/material'
import CloseIcon from '@mui/icons-material/Close'

// Components
import { BotaoPadrao } from '../../Formulario/BotaoPadrao'

interface ModalPadraoProps {
    open: boolean
    onClose: () => void
    title: string | ReactNode
    content: ReactNode
    isLoading?: boolean
    actions?: ReactNode
    confirmButtonText?: string
    cancelButtonText?: string
    handleConfirm?: () => void
    handleCancel?: () => void
}

export function ModalPadrao({
    open,
    onClose,
    title,
    content,
    isLoading,
    actions,
    confirmButtonText,
    cancelButtonText,
    handleConfirm,
    handleCancel,
}: ModalPadraoProps) {
    return (
        <Dialog open={open} onClose={onClose} fullWidth keepMounted scroll={'body'}>
            <DialogTitle>
                <Typography sx={{ fontWeight: 600 }}>{title}</Typography>
                <IconButton
                    sx={{
                        position: 'absolute',
                        borer: 0,
                        right: 1.5,
                        top: 1.5,
                    }}
                    size='small'
                    color='default'
                    aria-label='Fechar'
                    onClick={onClose}
                >
                    <CloseIcon fontSize='inherit' />
                </IconButton>
            </DialogTitle>
            <DialogContent>{content}</DialogContent>
            <DialogActions sx={{ margin: '0 16px 16px 16px' }}>
                {actions || (
                    <Grid container spacing={2} alignItems='center' justifyContent='flex-end'>
                        <BotaoPadrao
                            onClick={() => {
                                onClose()
                                if (handleCancel) {
                                    handleCancel()
                                }
                            }}
                            variant='outlined'
                        >
                            {cancelButtonText ?? 'Cancelar'}
                        </BotaoPadrao>
                        <BotaoPadrao variant='contained' onClick={handleConfirm} loading={isLoading}>
                            {confirmButtonText ?? 'Confirmar'}
                        </BotaoPadrao>
                    </Grid>
                )}
            </DialogActions>
        </Dialog>
    )
}

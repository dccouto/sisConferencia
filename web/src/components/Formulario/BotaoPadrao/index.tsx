import { Button, ButtonProps, Grid, GridProps, useMediaQuery } from '@mui/material'
import CircularProgress from '@mui/material/CircularProgress'
import { ReactNode } from 'react'

interface IBotaoPadraoProps extends ButtonProps {
    children?: string | ReactNode
    loading?: boolean
    component?: string
    gridProps?: GridProps
}

export function BotaoPadrao({ loading, children, fullWidth, gridProps, ...buttonProps }: IBotaoPadraoProps) {
    const isDesktop = useMediaQuery('(min-width:600px)')

    return (
        <Grid item xs={12}>
            <Button
                variant='contained'
                size='medium'
                color='secondary'
                fullWidth={fullWidth === undefined && !isDesktop}
                {...buttonProps}
                startIcon={loading ? <CircularProgress size={22} color='inherit' /> : buttonProps.startIcon}
                disabled={loading}
                sx={{
                    borderRadius: '10px',
                    fontWeight: 700,
                    paddingY: buttonProps.size === 'large' ? '10px' : 'auto',
                    marginTop: '5px',
                    ...buttonProps.sx,
                }}
            >
                {loading ? 'Carregando...' : children}
            </Button>
        </Grid>
    )
}

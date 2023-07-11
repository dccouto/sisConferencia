import { Paper, Typography } from '@mui/material'

interface AvisoSemRegistrosProps {
    status: string
    color: string
    border: string
    backgroung: string
}

export function ChipStatus({ status, color, border, backgroung }: AvisoSemRegistrosProps) {
    return (
        <Paper
            sx={{
                bgcolor: backgroung,
                border: `1px solid ${border}`,
                borderRadius: '10px',
                boxShadow: 'none',
                display: 'flex',
                justifyContent: 'center',
                alignItems: 'center',
                width: '100%',
                minHeight: '35px',
            }}
        >
            <Typography fontSize={12} color={color} fontWeight={'500'}>
                {status}
            </Typography>
        </Paper>
    )
}

ChipStatus.defaultProps = {
    backgroung: '#CCC',
    status: 'Status',
    color: '#525960',
    border: '#CCC',
}

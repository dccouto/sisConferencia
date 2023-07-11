import { Box, Typography } from '@mui/material'

import Mask from '../../../utils/mask'

// Services
interface Props {
    titulo: string
    valor: string
    sigla: boolean
    db: boolean
    width: number
    height: number
    style?: React.CSSProperties
}

const CardValorTotal = ({ titulo, valor, sigla, db, width, height, style }: Props) => {
    return (
        <Box
            padding={1}
            paddingLeft={1.4}
            style={{
                minWidth: width,
                height,
                border: 1,
                borderColor: Number(valor) < 0 ? 'red' : 'gray',
                borderRadius: 7,
                borderStyle: 'dashed',
                textAlign: 'left',
                ...style,
            }}
        >
            <Typography variant='caption' component='div'>
                {titulo}
            </Typography>
            <Typography variant='subtitle2' component='div' fontWeight={'bold'}>
                {Mask.formatReal(valor, sigla, db)}
            </Typography>
        </Box>
    )
}

CardValorTotal.defaultProps = {
    titulo: 'Subtotal',
    valor: '0',
    debug: false,
    sigla: false,
    db: false,
    width: 150,
    height: 60,
}

export default CardValorTotal

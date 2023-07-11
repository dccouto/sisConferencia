import { Box, Typography } from '@mui/material'
import ErrorIcon from '@mui/icons-material/Error'


const BannerWarning = () => {
    return (
        <Box
            padding={1}
            paddingLeft={1.4}  
            marginTop={2}          
            style={{
                minWidth: 100,   
                backgroundColor: '#ff8f00',
                color: 'white',           
                textAlign: 'left',           
                display:'flex'                    
            }}
        >
            <ErrorIcon />
            <Typography variant='caption' component='div' color={'warning'} ml={2} alignSelf={'center'}>
                Tem certeza de que a quantidade informada está correta? Caso esteja correto, o valor da solicitação será acima do esperado!
            </Typography>        
        </Box>
    )
}



export default BannerWarning

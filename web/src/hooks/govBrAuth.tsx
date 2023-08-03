import { useLocation } from 'react-router-dom';
import { Titulo } from '../components/Navegacao/Titulo';
import { obterTokenSso, mockLogin, loginGovBr } from '../services/auth';
import { Buffer } from 'buffer';
import LoginProcess from '../pages/Login/LoginProcess';
import { useAuth } from './useAuth';
import { ITokenSso, IUsuarioGovBr } from '../services/auth/types';


export default function GovBrContext() { // nome do componente atualizado   
  let location = useLocation();
  let params = new URLSearchParams(location.search);
  let code = params.get('code');
  const { login } = useAuth()

  console.log(code);

        const obterToken = async () => {
            if (code)  {
                const result : ITokenSso = await obterTokenSso(code)
        
                console.log(result)
                if(result.token){
                    //DECODIFICA TOKEN
                    let parts = result.token.split('.');
                    if (parts.length !== 3) {
                        throw new Error('Token inválido');
                    }
                    
                    let payloadBase64 = parts[1];
                    let payloadJson = Buffer.from(payloadBase64, 'base64').toString('utf8');
                    let payload : IUsuarioGovBr= JSON.parse(payloadJson);
                    
                    //PROCESSA OBJETO COM PAYLOAD DECODIFICADO
                    const newAuthGovBr= await loginGovBr(payload);

                    login(newAuthGovBr);
                    
                }
            } 
          
        
        }


        obterToken()




  
  return (
    <>
      <LoginProcess/>
    </>
  )
}
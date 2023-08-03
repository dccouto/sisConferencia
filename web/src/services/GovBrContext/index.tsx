import { useLocation } from 'react-router-dom';
import { Titulo } from '../../components/Navegacao/Titulo';

export default function GovBrContext() { // nome do componente atualizado   
  let location = useLocation();
  let params = new URLSearchParams(location.search);
  let code = params.get('code');

  console.log(code);
  // Agora você pode usar a variável `code` no seu componente
  return (
    <>
      <Titulo titulo={`GOVBR`} />
    </>
  )
}
import { useNavigate, useParams } from 'react-router-dom'

// Types

// Components
import { Breadcrumbs } from '../../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../../components/Navegacao/Titulo'

const paginaInicial = '/perfil'

export default function CadastrarPerfil() {
    const navigate = useNavigate()

    const { coPerfil } = useParams()

    return (
        <>
            <Breadcrumbs
                current={`${coPerfil ? 'Editar' : 'Cadastrar'} Perfil`}
                prevCrumbs={[{ name: 'Administração' }, { name: 'Permissões' }, { name: 'Perfil', to: paginaInicial }]}
            />
            <Titulo titulo={`${coPerfil ? 'Editar' : 'Cadastrar'} Perfil`} voltar={paginaInicial} />
        </>
    )
}

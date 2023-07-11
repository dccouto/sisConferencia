// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'

const paginaInicial = '/perfil'

export default function CadastrarPerfil() {
    return (
        <>
            <Breadcrumbs
                current={`Perfil`}
                prevCrumbs={[{ name: 'Administração' }, { name: 'Permissões' }, { name: 'Perfil', to: paginaInicial }]}
            />
            <Titulo titulo={`Perfil`} voltar={paginaInicial} />
        </>
    )
}

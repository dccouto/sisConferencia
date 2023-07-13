// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import { Admin, Resource } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import { PostList } from '../posts';


const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');

export default function CadastrarPerfil() {
    return (
        <>
            <Breadcrumbs
                current={`Configurações do Sistema`}
                prevCrumbs={[{ name: 'Administração' }, { name: 'Tabelas de Apoio' }]}
            />
            <Titulo titulo={`Tabelas de Apoio`} voltar={paginaInicial} />

            <Admin dataProvider={dataProvider}>
                <Resource name="posts" list={PostList} />
                

            </Admin>
        </>
    )
}

// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import { Admin, Resource } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import PortariaCrud from './PortariaCrud';


// Services
import apiServicePortaria from './../../../services/sisConferenciaApi/portaria/index';
import { useEffect, useState } from 'react';
import { IPortaria } from './../../../services/sisConferenciaApi/portaria/types';



const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig = [
    { key: 'id', displayName: 'ID', width: 300 ,visible:true},
    { key: 'descricao', displayName: 'Descrição',visible:true},
    { key: 'dataPortaria', displayName: 'Data',visible:true},
    { key: 'numero', displayName: 'Número',visible:true},
]



export default function Portaria() {

    const [portarias,setPortarias] = useState<IPortaria[]>([])


    useEffect(() => {
        

        async function buscarListaPortaria() {
            try {
                const result = await apiServicePortaria.listar();
                if (Array.isArray(result)) {
                    setPortarias(result);
                } else {
                    console.error("Result is not an array");
                }
            } catch (error) {
                console.error(error);
            }
        }

        buscarListaPortaria();
    }, [])
    
    return (
        <>
            <Breadcrumbs
                current={`Portaria`}
                prevCrumbs={[{ name: 'Administração' }]}
            />  
            <Titulo titulo={`Portaria`} voltar={paginaInicial} />

            <PortariaCrud visible={true} portarias={portarias} setPortarias={setPortarias} apiService={apiServicePortaria} columnConfig={columnsConfig}></PortariaCrud>
        </>
    )
}


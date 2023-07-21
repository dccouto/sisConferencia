// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import jsonServerProvider from 'ra-data-json-server';
import TipoEventoCrud from './TipoEventoCrud';


// Services
import apiServiceTipoEvento from './../../../services/sisConferenciaApi/tipoEvento/index';
import { useEffect, useState } from 'react';
import { ITipoEvento } from './../../../services/sisConferenciaApi/tipoEvento/types';



const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig = [
    { key: 'id', displayName: 'ID', width: 300 ,visible:true},
    { key: 'descricao', displayName: 'Descrição',visible:true},
]



export default function TipoEvento() {

    const [tipoEventos,setTipoEventos] = useState<ITipoEvento[]>([])


    useEffect(() => {
        

        async function buscarListaTipoEvento() {
            try {
                const result = await apiServiceTipoEvento.listar();
                if (Array.isArray(result)) {
                    setTipoEventos(result);
                } else {
                    console.error("Result is not an array");
                }
            } catch (error) {
                console.error(error);
            }
        }

        buscarListaTipoEvento();
    }, [])
    
    return (
        <>
            <Breadcrumbs
                current={`Tipo de Evento`}
                prevCrumbs={[{ name: 'Administração' }]}
            />  
            <Titulo titulo={`Tipo de Evento`} voltar={paginaInicial} />

            <TipoEventoCrud visible={true} tipoEventos={tipoEventos} setTipoEventos={setTipoEventos} apiService={apiServiceTipoEvento} columnConfig={columnsConfig}></TipoEventoCrud>
        </>
    )
}


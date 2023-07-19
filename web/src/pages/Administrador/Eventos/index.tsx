// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import { Admin, Resource } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';


// Services

import { useEffect, useState } from 'react';
import { IListaEventos } from '../../../services/sisConferenciaApi/eventos/types';
import EventoCrud from './EventoCrud';
import apiServiceEventos from '../../../services/sisConferenciaApi/eventos';



const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig= [
    { key: 'id', displayName: 'ID', width: 300, visible: true },
    { key: 'descricao', displayName: 'Descrição', visible: true },
    { key: 'dataCadastro', displayName: 'Data Cadastro', visible: true },
    { key: 'dataFinal', displayName: 'Data Final', visible: true },
    { key: 'dataInicial', displayName: 'Data Inicial', visible: true },
    { key: 'portaria', displayName: 'Portaria', visible: true },
    { key: 'tema', displayName: 'Tema', visible: true },
    { key: 'tipoEvento', displayName: 'Tipo de Evento', visible: true },
    { key: 'tipoRegime', displayName: 'Tipo de Regime', visible: true },
];



export default function Eventos() {

    const [Eventos,setEventos] = useState<IListaEventos>([])


    useEffect(() => {
        

        async function buscarListaEventos() {
            try {
                const result = await apiServiceEventos.listar();
                if (Array.isArray(result)) {
                    setEventos(result);
                } else {
                    console.error("Result is not an array");
                }
            } catch (error) {
                console.error(error);
            }
        }

        buscarListaEventos();
    }, [])
    
    return (
        <>
            <Breadcrumbs
                current={`Eventos`}
                prevCrumbs={[{ name: 'Administração' }]}
            />
            <Titulo titulo={`Eventos`} voltar={paginaInicial} />

            <EventoCrud visible={true} eventos={Eventos} setEventos={setEventos} apiService={apiServiceEventos} columnConfig={columnsConfig}></EventoCrud>
        </>
    )
}
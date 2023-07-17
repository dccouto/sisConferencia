// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import { Admin, Resource } from 'react-admin';
import jsonServerProvider from 'ra-data-json-server';
import TipoEventoCrud from './TipoEventoCrud';


// Services
import apiService from './../../../services/sisConferenciaApi/tipoEvento/index';
import { useEffect, useState } from 'react';
import { ITipoEvento } from './../../../services/sisConferenciaApi/tipoEvento/types';



const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');

export default function TipoEvento() {

    const [tipoEventos,setTipoEventos] = useState<ITipoEvento[]>([])


    useEffect(() => {
        

        async function buscarListaTipoEvento() {
            try {
                const result = await apiService.tipoEventoListar();
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
                current={`Configurações do Sistema`}
                prevCrumbs={[{ name: 'Administração' }, { name: 'Tabelas de Apoio' }]}
            />
            <Titulo titulo={`Tabelas de Apoio`} voltar={paginaInicial} />

            <TipoEventoCrud visible={true} tipoEventos={tipoEventos} setTipoEventos={setTipoEventos} ></TipoEventoCrud>
        </>
    )
}


// Components
import { Breadcrumbs } from '../../../components/Navegacao/Breadcrumbs'
import { Titulo } from '../../../components/Navegacao/Titulo'
import jsonServerProvider from 'ra-data-json-server';
import FormatoCrud from './FormatoCrud';


// Services
import apiServiceFormato from './../../../services/sisConferenciaApi/formato/index';
import { useEffect, useState } from 'react';
import { IFormato } from './../../../services/sisConferenciaApi/formato/types';



const paginaInicial = '/home'


const dataProvider = jsonServerProvider('https://jsonplaceholder.typicode.com');


const columnsConfig = [
    { key: 'id', displayName: 'ID', width: 300 ,visible:true},
    { key: 'descricao', displayName: 'Descrição',visible:true},
]



export default function Formato() {

    const [formatos,setFormatos] = useState<IFormato[]>([])


    useEffect(() => {
        

        async function buscarListaFormato() {
            try {
                const result = await apiServiceFormato.listar();
                if (Array.isArray(result)) {
                    setFormatos(result);
                } else {
                    console.error("Result is not an array");
                }
            } catch (error) {
                console.error(error);
            }
        }

        buscarListaFormato();
    }, [])
    
    return (
        <>
            <Breadcrumbs
                current={`Formato de Evento`}
                prevCrumbs={[{ name: 'Administração' }]}
            />  
            <Titulo titulo={`Formato de Evento`} voltar={paginaInicial} />

            <FormatoCrud visible={true} formatos={formatos} setFormatos={setFormatos} apiService={apiServiceFormato} columnConfig={columnsConfig}></FormatoCrud>
        </>
    )
}


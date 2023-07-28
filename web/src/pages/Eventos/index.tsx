// Components

import jsonServerProvider from 'ra-data-json-server';


// Services

import { useEffect, useState } from 'react';
import apiServiceEventos from '../../services/sisConferenciaApi/eventos';
import { Titulo } from '../../components/Navegacao/Titulo';
import { Breadcrumbs } from '../../components/Navegacao/Breadcrumbs';
import { IListaEventos } from '../../services/sisConferenciaApi/eventos/types';
import { Box, Card, Grid, Typography } from '@mui/material';
import EventosFiltro from './Filtros';




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



export default function Eventos_conferencia_reunioes() {

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
                current={`Conferências e Reuniões`}
                prevCrumbs={[{ name: 'Eventos' }]}
            />
       


            <Titulo titulo={`Eventos`} voltar={paginaInicial} />

            <Grid item xs={12}>    
                <Box display='flex' justifyContent='center' alignItems='center'>
                            
                            <Card style={{paddingLeft:'20px', paddingBottom:'10px', paddingRight:'10px'}}>
                                <Titulo titulo={`CNAS – SISCONFERÊNCIA`}  />
                                <Typography>
                                Bem-vindo ao módulo de Conferências e Reuniões do Conselho Nacional de Assistência Social – CNAS. Neste local poderá
                                ter acesso às informações de todas as Conferências Nacionais já realizadas, bem como a que está programada ou em
                                Cadastro Conselheiros Eleição Sociedade Civil curso. Também dará acesso as Reuniões Ordinárias, Extraordinárias, Reuniões Descentralizadas e Ampliadas, bem como as reuniões Trimestrais do CNAS, CEAS e CAS/DF. Para localizar o evento que deseja visualizar, preencha a(s) informação(ões) na caixa de pesquisa abaixo. O Conselho agradece a sua visita. Estamos trabalhando para levar todas as informações que desejar.

                                </Typography>
                            </Card>
                            
                    
                </Box>
            </Grid>

            <Grid item xs={12} style={{paddingTop:'40px'}}>    
                <EventosFiltro></EventosFiltro>
            </Grid>


           
        </>
    )
}
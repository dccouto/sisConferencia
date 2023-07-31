import { useEffect, useState } from 'react';
import apiServiceEventos from '../../services/sisConferenciaApi/eventos';
import { Titulo } from '../../components/Navegacao/Titulo';
import { Breadcrumbs } from '../../components/Navegacao/Breadcrumbs';
import { IListaEventos } from '../../services/sisConferenciaApi/eventos/types';
import { Box, Card, Grid, Typography } from '@mui/material';
import { format, parseISO } from 'date-fns';
import { FormProvider, useForm } from 'react-hook-form';
import { DataGrid, ptBR } from '@mui/x-data-grid';

const paginaInicial = '/home'

export default function Eventos_conferencia_reunioes() {

    const [eventos,setEventos] = useState<IListaEventos>([])

    const columns = [
        { field: 'tipoEvento', headerName: 'Tipo de Evento', flex: 1,valueGetter: (params : any) => params.row.tipoEvento.descricao,}, 
        { field: 'nome', headerName: 'Nome', flex: 3 },
        { field: 'objetivo', headerName: 'Objetivo', flex: 1  },
        { field: 'dataInicial', headerName: 'Data Inicial', flex: 1,valueGetter: (params : any) =>  format( parseISO(params.row.dataInicial), 'dd/MM/yyyy'),},
        { field: 'dataFinal', headerName: 'Data Final', flex: 1, valueGetter: (params : any) => format( parseISO(params.row.dataFinal),'dd/MM/yyyy'),},
      ];


    const rhfmethods = useForm<IListaEventos>({})

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
                current={`Conferências e reuniões`}
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
            <FormProvider {...rhfmethods}>
               

                        <DataGrid
                           rows={eventos}
                           localeText={ptBR.components.MuiDataGrid.defaultProps.localeText} 
                           columns={columns}
                           initialState={{
                            pagination: {
                              paginationModel: { pageSize: 10, page: 0 },
                            },
                          }}
                        />                       
               
               
            </FormProvider>
            </Grid>


           
        </>
    )
}
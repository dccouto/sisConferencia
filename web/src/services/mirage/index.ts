import { ActiveModelSerializer, createServer, Factory, Model } from 'miragejs'

import faker from '@faker-js/faker'

/*
 * MirageJs - Ferramenta para simular uma resposta de API do backend
 * https://miragejs.com/docs/getting-started/introduction/
 */

type User = {
    nome: string
    email: string
    data_criacao: string
    perfil: string
    uf: string
    municipio: string
}

export function makeServer() {
    return createServer({
        serializers: {
            application: ActiveModelSerializer,
        },

        models: {
            user: Model.extend<Partial<User>>({}),
        },

        factories: {
            user: Factory.extend({
                nome(i: number) {
                    return `User ${i + 1}`
                },
                email() {
                    return faker.internet.email().toLowerCase()
                },
                data_criacao() {
                    return faker.date.recent(10)
                },
                perfil() {
                    return faker.helpers.randomize([
                        'Administrador',
                        'Gestor Municipal',
                        'Gestor Estadual',
                        'Parlamentar',
                    ])
                },
                uf() {
                    return faker.helpers.randomize(['MG', 'PR', 'RJ', 'GO', 'SP'])
                },
                municipio() {
                    return faker.helpers.randomize([
                        { cod: 111, desc: 'Minas Gerais' },
                        { cod: 223, desc: 'Londrina' },
                        { cod: 222, desc: 'Curitiba' },
                        { cod: 333, desc: 'Rio de Janeiro' },
                        { cod: 444, desc: 'Goiânia' },
                        { cod: 444, desc: 'São Paulo' },
                    ])
                },
            }),
        },

        seeds(server) {
            server.createList('user', 200)
        },

        routes() {
            this.namespace = 'api'
            // this.timing = 2000;

            this.post('/users', function (schema, req) {
                const { uf, municipio } = JSON.parse(req.requestBody)

                const allUsers = schema.all('user')

                // const pageStart = (Number(page) - 1) * Number(per_page);
                // const pageEnd = pageStart + Number(per_page);
                //
                // const users = this.serialize(schema.all("user")).users.slice(
                //   pageStart,
                //   pageEnd
                // );
                return allUsers.filter((user) => {
                    if (municipio && municipio !== 0) {
                        return user.uf === uf && user.municipio.cod === municipio
                    } else if (uf && municipio === 0 && uf !== 0) {
                        return user.uf === uf
                    } else {
                        return user
                    }
                })
            })

            this.post('/user', (schema, req) => {
                const user = req.requestBody

              

                return user
                // schema.create("user", req.requestBody)
            })

            // this.get("/users");
            this.get('/users/:id')
            this.get('/uf', () => {
                return ['MG', 'PR', 'RJ', 'GO', 'SP']
            })
            this.get('/municipio/:uf', (schema, req) => {
                let uf = req.params.uf
                const ufs: { [key: string]: {} } = {
                    MG: [{ cod: 111, desc: 'Minas Gerais' }],
                    PR: [
                        { cod: 222, desc: 'Curitiba' },
                        { cod: 223, desc: 'Londrina' },
                    ],
                    RJ: [{ cod: 333, desc: 'Rio de Janeiro' }],
                    GO: [{ cod: 444, desc: 'Goiânia' }],
                    SP: [{ cod: 444, desc: 'São Paulo' }],
                }

                return ufs[uf]
            })

            this.namespace = 'mirage'
            this.passthrough()
        },
    })
}

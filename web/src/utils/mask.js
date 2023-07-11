const Mask = {
    // (00) 00000-0000
    telefone(telefone) {
        if (!telefone) return

        let v = telefone
        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito
        v = v.replace(/^(\d{2})(\d)/g, '($1) $2') // Coloca parênteses em volta dos dois primeiros dígitos
        v = v.replace(/(\d)(\d{4})$/, '$1-$2') // Coloca hífen entre o quarto e o quinto dígitos
        return v
    },

    // 00000-000
    cep(cep) {
        if (!cep) return

        let v = cep
        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito
        v = v.replace(/^(\d{5})(\d)/g, '$1-$2') // Coloca parênteses em volta dos dois primeiros dígitos
        // v=v.replace(/(\d)(\d{4})$/,"$1-$2");    // Coloca hífen entre o quarto e o quinto dígitos
        return v.substr(0, 9)
    },

    hora(hora) {
        if (!hora) return

        let v = hora
        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito
        v = v.replace(/^(\d{2})(\d)/g, '$1:$2') // Coloca barra depois dos dois primeiros dígitos
        return v.substr(0, 5)
    },

    number(value) {
        if (!value) return

        let v = value
        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito

        return v
    },

    dataBR(data, split = false) {
        if (!data) return ''

        if (split) {
            return data.split('-').reverse().join('/');
        }

        let v = data
        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito
        v = v.replace(/^(\d{2})(\d)/g, '$1/$2') // Coloca barra depois dos dois primeiros dígitos
        v = v.replace(/(\d)(\d{4})$/, '$1/$2') // Coloca barra depois dos quatro primeiros dígitos

        return v
    },

    dataUS(data) {
        if (!data) return

        var dia = data.split('/')[0]
        var mes = data.split('/')[1]
        var ano = data.split('/')[2]

        return ano + '-' + ('0' + mes).slice(-2) + '-' + ('0' + dia).slice(-2)
    },

    // 000.000.000-00
    maskCPF(cpf) {
        if (!cpf) return

        let v = cpf
        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito
        v = v.replace(/(\d{3})(\d)/, '$1.$2') // Coloca um ponto entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{3})(\d)/, '$1.$2') // Coloca um ponto entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{3})(\d{1,2})$/, '$1-$2') // Coloca um hífen entre o terceiro e o quarto dígitos
        return v
    },

    // 00.000.000/0000-00
    maskCNPJ(cnpj) {
        if (!cnpj) return

        let v = cnpj
        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito
        v = v.replace(/(\d{2})(\d)/, '$1.$2') // Coloca um ponto entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{3})(\d)/, '$1.$2') // Coloca um ponto entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{3})(\d)/, '$1/$2') // Coloca um ponto entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{4})(\d)/, '$1-$2') // Coloca um ponto entre o terceiro e o quarto dígitos
        return v
    },

    // 00.000.000/0000-00
    maskPhone(phone) {
        if (!phone) return

        let v = phone
        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito
        v = v.replace(/(\d{0})(\d)/, '$1($2') // Coloca um ponto entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{2})(\d)/, '$1) $2') // Coloca um ponto entre o terceiro e o quarto dígitos
        v = v.replace(/(\d{5})(\d)/, '$1-$2') // Coloca um ponto entre o terceiro e o quarto dígitos
        // v=v.replace(/(\d{4})(\d)/,"$1-$2") // Coloca um ponto entre o terceiro e o quarto dígitos
        return v
    },

    formatRealOld(valor, sigla = false) {
        if (!valor) return

        let v = valor.toString()

        v = v.replace(/\D/g, '') // Remove tudo o que não é dígito

        if (v.length > 2) {
            v = v.replace(/([0-9]{2})$/g, ',$1')
        }

        if (v.length > 6) {
            v = v.replace(/([0-9]{3}),([0-9]{2}$)/g, '.$1,$2')
        }

        return sigla ? `R$ ${v}` : v
    },

    formatRealOld2(valor, sigla = false) {
        if (!valor) return

        let v = valor.toString()

        v = valor.replace(/\D/g, '')

        v = reverse(v.replace(/[^\d]+/gi, ''));

        var resultado = "";

        var mascara = reverse("##.###.###,##");

        for (var x = 0, y = 0; x < mascara.length && y < v.length;) {
            if (mascara.charAt(x) !== '#') {
                resultado += mascara.charAt(x);
                x++;
            } else {
                resultado += v.charAt(y);
                y++;
                x++;
            }
        }

        v = reverse(resultado)

        return sigla ? `R$ ${v}` : v
    },


    formatUS(valor, isNumber = false) {
        if (!valor) return isNumber ? 0 : ""

        let v = valor
        v = v.replace(/\./g, '')
        v = v.replace(',', '.')

        return isNumber ? parseFloat(v) : v
    },

    numeros(valor) {
        let v = valor.toString()

        v = v.replace(/([^\d])+/gim, '');

        v = v.replace('e', '')

        return v
    },

    quantidade(valor) {
        let v = valor.toString()

        if (!v) return 0

        if (v.length > 0) {
            v = v.replace(/([^\d])+/gim, '');
            v = v.replace('e', '')
        }

        return v
    },

    ucFirstAllWords(str) {
        str = str.replace('-', ' ')
        var pieces = str.split(' ')
        for (var i = 0; i < pieces.length; i++) {
            var j = pieces[i].charAt(0).toUpperCase()
            pieces[i] = j + pieces[i].substr(1)
        }
        return pieces.join(' ')
    },

    removeMask(valor) {
        if (!valor) return ''

        let v = valor.toString()

        return v.replace(/\D/g, '')
    },

    formatReal(value, sigla = false, db = false) {
        if (!value) return

        let v = value.toString()

        let vSlice = value.toString()

        if (db) {
            v = parseFloat(v).toFixed(2)
        }

        const onlyDigits = v.split("").filter(s => /\d/.test(s)).join("").padStart(3, "0")

        const digitsFloat = onlyDigits.slice(0, -2) + "." + onlyDigits.slice(-2)

        v = new Intl.NumberFormat('pt-BR', {
            style: 'currency',
            currency: 'BRL'
        }).format(vSlice.slice(0, 1) === '-' ? -digitsFloat : digitsFloat)

        return sigla ? v : v.replace('R$ ', '')
    }
}

function reverse(v) {
    return v.split('').reverse().join('');
};



export default Mask

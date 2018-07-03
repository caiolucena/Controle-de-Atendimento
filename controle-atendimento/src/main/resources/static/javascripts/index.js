var $ = jQuery;
function selecionouEstado(id, url) {
	$.ajax({
		url : url,
		method : 'POST',
		contentType : 'application/json',
		data : JSON.stringify({
			id : id
		}),
		error : erroEstado,
		success : selecionarCidade
	});

	function selecionarCidade(cidades) {
		var comboCidade = $("#cidade");
		comboCidade
				.html('<option value =' + 0 + '>Selecione a Cidade</option>');

		for ( var i in cidades) {
			comboCidade.append('<option value =' + cidades[i].id + '>'
					+ cidades[i].nome + '</option>');
		}

	}
	function erroEstado() {
		console.log('Erro em carregar as cidades!')
	}

}


function selecionouCliente(id, url) {
	$.ajax({
		url : url,
		method : 'POST',
		contentType : 'application/json',
		data : JSON.stringify({
			id : id
		}),
		error : erroCliente,
		success : alterarCliente
	});

	function alterarCliente(cliente) {

		document.getElementById("nomeCliente").value = cliente.nome;
	}
	function erroCliente() {
		console.log('Erro em carregar o Cliente!')
	}

}

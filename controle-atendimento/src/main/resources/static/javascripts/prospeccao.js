var $ = jQuery;


$(function() {
	
	console.log("executei aqui!");
	
	$.ajax({
		url : '/atendimento/chamados',
		method : 'POST',
		contentType : 'application/json',
		error : erroChamado,
		success : adicionarCamposChamado
	});
	
	function adicionarCamposChamado(chamado) {
		console.log("Nao deu erro aqui");
		var codigo = $('#codigoCliente');
		var nome = $('#nomeCliente');
		var telefone = $('#telefone');
		var telefoneOpt = $('#telefoneOpt');
		var email = $('#email');
		var cidade = $('#cidade');
		var estado = $('#uf');
		var infoChamado = $('#infoChamado');
		
		codigo.val(chamado.cliente.id);
		nome.val(chamado.nomeCliente);
		telefone.val(chamado.telefone);
		telefoneOpt.val(chamado.telefoneOpt);
		email.val(chamado.email);
		cidade.val(chamado.cidade.nome);
		estado.val(chamado.cidade.estado.sigla);
		infoChamado.val(chamado.observacao);
		
		
	}
	function erroChamado() {
		var nomeCliente = $("#nomeCliente");
	
		nomeCliente.val("Não há cliente cadastrado com o código informado");
	}
	
});


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
		console.log("Nao deu erro aqui");
		var nomeCliente = $("#nomeCliente");
//		var telefoneCliente = $("#telefone");
//		var telefoneOptCliente = $("#telefoneOpt");
//		var email = $("#email");
		if(cliente){
			nomeCliente.val(cliente.nome);	
		}
		else{
			nomeCliente.val("Não há cliente cadastrado com o código informado");
		}
		
	}
	function erroCliente() {
		var nomeCliente = $("#nomeCliente");
	
		nomeCliente.val("Não há cliente cadastrado com o código informado");
	}

}

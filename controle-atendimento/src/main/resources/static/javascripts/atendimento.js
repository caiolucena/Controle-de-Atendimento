var Atendimento = Atendimento || {}
var $ = jQuery;

Atendimento.MaskMoney = (function() {
	function MaskMoney() {
		this.decimal = $('.js-decimal');
		this.plain = $('.js-plain');
	}
	MaskMoney.prototype.enable = function() {
		this.decimal.maskMoney({
			thousands : '.',
			decimal : ','
		}); //
		this.plain.maskMoney({
			precision : 0,
			thousands : "."
		});
	}
	return MaskMoney;
}());

Atendimento.MaskPhoneNumber = (function() {

	function MaskPhoneNumber() {
		this.inputPhoneNumber = $('.js-phone-number');
	}

	MaskPhoneNumber.prototype.enable = function() {
		var maskBehavior = function(val) {
			return val.replace(/\D/g, '').length === 11 ? '(00) 00000-0000'
					: '(00) 0000-00009';
		};

		var options = {
			onKeyPress : function(val, e, field, options) {
				field.mask(maskBehavior.apply({}, arguments), options);
			}
		};

		this.inputPhoneNumber.mask(maskBehavior, options);
	}

	return MaskPhoneNumber;

}());

Atendimento.MaskCpf = (function() {

	function MaskCpf() {
		this.inputCpf = $('.js-cpf');
	}
	MaskCpf.prototype.enable = function() {
		this.inputCpf.mask('000.000.000-00', {
			reverse : true
		});

	}

	return MaskCpf;
}());
Atendimento.MaskData = (function() {

	function MaskCpf() {
		this.inputData = $('.js-data');
	}
	MaskCpf.prototype.enable = function() {
		this.inputData.mask('00/00/0000', {
			reverse : true
		});

	}

	return MaskCpf;
}());


Atendimento.MaskCnpj = (function() {

	function MaskCnpj() {
		this.inputCnpj = $('.js-cnpj');
	}
	MaskCnpj.prototype.enable = function() {
		this.inputCnpj.mask('000.000.000/0000-00', {
			reverse : true
		});

	}

	return MaskCnpj;
}());

Atendimento.MaskCep = (function() {

	function MaskCep() {
		this.inputCep = $('.js-cep');
	}

	MaskCep.prototype.enable = function() {
		this.inputCep.mask('00.000-000');
	}

	return MaskCep;

}());

Atendimento.MaskDate = (function() {

	function MaskDate() {
		this.inputDate = $('.js-date');
	}

	MaskDate.prototype.enable = function() {
		this.inputDate.mask('00/00/0000');
		this.inputDate.datepicker({
			// orientation: 'bottom',
			language : 'pt-BR',
			autoclose : true
		});
	}

	return MaskDate;

}());

numeral.language('pt-br');

Atendimento.formatarMoeda = function(valor) {
	return numeral(valor).format('0,0.00');
}

Atendimento.recuperarValor = function(valorFormatado) {
	return numeral().unformat(valorFormatado);
}
Atendimento.MaskHour = (function() {

	function MaskHour() {
		this.inputHour = $('.js-hour');
	}
	MaskHour.prototype.enable = function() {
		this.inputHour.mask('00:00', {
			reverse : true
		});

	}

	return MaskHour;
}());

$(function() {

	var maskMoney = new Atendimento.MaskMoney();
	maskMoney.enable();

	var maskPhoneNumber = new Atendimento.MaskPhoneNumber();
	maskPhoneNumber.enable();

	var maskCpf = new Atendimento.MaskCpf();
	maskCpf.enable();

	var maskCep = new Atendimento.MaskCep();
	maskCep.enable();

	var maskCnpj = new Atendimento.MaskCnpj();
	maskCnpj.enable();

	var maskDate = new Atendimento.MaskDate();
	maskDate.enable();
	
	var maskHour = new Atendimento.MaskHour();
	maskHour.enable();

});
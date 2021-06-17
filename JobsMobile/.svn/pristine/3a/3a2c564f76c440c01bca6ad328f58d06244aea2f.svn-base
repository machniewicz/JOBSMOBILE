package br.com.jobs.ws;

import java.util.List;

import org.ksoap2.HeaderProperty;
import org.ksoap2.SoapEnvelope;
import org.ksoap2.serialization.MarshalBase64;
import org.ksoap2.serialization.SoapObject;
import org.ksoap2.serialization.SoapPrimitive;
import org.ksoap2.serialization.SoapSerializationEnvelope;
import org.ksoap2.transport.HttpTransportSE;

import android.util.Log;
import br.com.jobs.modelo.Curriculo;
import br.com.jobs.modelo.Enviado;
import br.com.jobs.modelo.Preferencia;

public class Webservice {

	public String NAMESPACE = "http://mobile.jobs.com.br";
//	public String url = "http://189.114.225.148:8088/WSJobsMobile/services/Controle?wsdl";
//	public String url = "http://192.168.25.121:8080/WSJobsMobile/services/Controle?wsdl";
//	public String url = "http://192.168.25.121:8080/WSJobsMobileTeste/services/Controle?wsdl";
//	public String url = "http://mobile.4usolucoes.com.br:8088/WSJobsMobileTeste/services/Controle?wsdl";
	
	/*
	 * URL - Cloud Integrator
	 */
	public String url = "http://jobsmobile.com.br/WSJobsMobile/services/Controle?wsdl";
	
	//public String url = "http://jobsmobile.com.br/WSJobsMobileTeste/services/Controle?wsdl";
	
	public String WS_ESTADO = "listaEstado";
	public String WS_ESTADO_RETURN = "listaEstadoReturn";
	
	public String WS_VAGA = "listaVaga";
	public String WS_VAGA_RETURN = "listaVagaReturn";
	
	public String WS_CATEGORIA = "listaCategoria";
	public String WS_CATEGORIA_RETURN = "listaCategoriaReturn";
	
	public String WS_RESUMO = "listaResumo";
	public String WS_RESUMO_RETURN = "listaResumoReturn";
	
	public String WS_BUSCA = "listaOportunidade";
	public String WS_BUSCA_RETURN = "listaOportunidadeReturn";
	
	public String WS_EMAIL = "listaConfiguracaoEmail";
	public String WS_EMAIL_RETURN = "listaConfiguracaoEmailReturn";
	
	public String WS_ESTATISTICA = "atualizarEstatitisca";
	
	public String WS_PRECADASTRO = "atualizarPrecadastro";
	
	public String WS_CURRICULO = "atualizarCurriculo";
	
	public String WS_NOTIFICACAO = "listaNotificacao";
	public String WS_NOTIFICACAO_RETURN = "listaNotificacaoReturn";
	
	public String WS_FORMACAO = "listaFormacao";
	public String WS_FORMACAO_RETURN = "listaFormacaoReturn";
	
	public String WS_SALARIO = "listaSalario";
	public String WS_SALARIO_RETURN = "listaSalarioReturn";
	
	public String WS_PREFERENCIA = "listaPreferencia";
	public String WS_PREFERENCIA_RETURN = "listaPreferenciaReturn";
		
	public int timeOut = 60000;

	public void setTimeOut(int seconds) {
		this.timeOut = seconds * 1000;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	/*
	 * Informações Preferencia - Webservice
	 * 
	 */
	
	public String consultarInformacoesPreferencia(String login, String senha) {
		return consultarInformacoesPreferenciaXML(null, login, senha);
	}

	public String consultarInformacoesPreferenciaXML(List<HeaderProperty> headers, String login, String senha) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_PREFERENCIA);
		soapReq.addProperty("login", login);
		soapReq.addProperty("senha", senha);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_PREFERENCIA,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_PREFERENCIA,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_PREFERENCIA_RETURN)) {
				Object obj = result.getProperty(WS_PREFERENCIA_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_PREFERENCIA_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	

	
	/*
	 * Informações Notificação de Oportunidades - WS
	 */
	public String consultarInformacoesNotificacao() {
		return consultarInformacoesNotificacaoXML(null);
	}

	public String consultarInformacoesNotificacaoXML(List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_NOTIFICACAO);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_NOTIFICACAO,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_NOTIFICACAO,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_NOTIFICACAO_RETURN)) {
				Object obj = result.getProperty(WS_NOTIFICACAO_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_NOTIFICACAO_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/*
	 * Informações Formação - Webservice
	 * 
	 */
	public String consultarInformacoesFormacao() {
		return consultarInformacoesFormacaoXML(null);
	}

	public String consultarInformacoesFormacaoXML(List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_FORMACAO);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_FORMACAO,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_FORMACAO,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_FORMACAO_RETURN)) {
				Object obj = result.getProperty(WS_FORMACAO_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_FORMACAO_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	

	/*
	 * Informações Salario - Webservice
	 * 
	 */
	public String consultarInformacoesSalario() {
		return consultarInformacoesSalarioXML(null);
	}

	public String consultarInformacoesSalarioXML(List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_SALARIO);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_SALARIO,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_SALARIO,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_SALARIO_RETURN)) {
				Object obj = result.getProperty(WS_SALARIO_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_SALARIO_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	
	

	/*
	 * Informações Estado - Webservice
	 * 
	 */
	public String consultarInformacoesEstado() {
		return consultarInformacoesEstadoXML(null);
	}

	public String consultarInformacoesEstadoXML(List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_ESTADO);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_ESTADO,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_ESTADO,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_ESTADO_RETURN)) {
				Object obj = result.getProperty(WS_ESTADO_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_ESTADO_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	

	/*
	 * Informações Categoria - Webservice
	 * 
	 */
	public String consultarInformacoesCategoria() {
		return consultarInformacoesCategoriaXML(null);
	}

	public String consultarInformacoesCategoriaXML(List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_CATEGORIA);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_CATEGORIA,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_CATEGORIA,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_CATEGORIA_RETURN)) {
				Object obj = result.getProperty(WS_CATEGORIA_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_CATEGORIA_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			Log.i("Falhou", "Caiu no catch... falou ws");
			e.printStackTrace();
		}
		return null;
	}
	
	/*
	 * Informações Vaga - Webservice
	 * 
	 */
	public String consultarInformacoesVaga() {
		return consultarInformacoesVagaXML(null);
	}

	public String consultarInformacoesVagaXML(List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_VAGA);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_VAGA,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_VAGA,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_VAGA_RETURN)) {
				Object obj = result.getProperty(WS_VAGA_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_VAGA_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	



	/*
	 * Informações E-Mail - Webservice
	 * 
	 */
	public String consultarInformacoesEmail() {
		return consultarInformacoesEmailXML(null);
	}

	public String consultarInformacoesEmailXML(List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_EMAIL);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_EMAIL,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_EMAIL,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_EMAIL_RETURN)) {
				Object obj = result.getProperty(WS_EMAIL_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_EMAIL_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	

	/*
	 * Informações Resumo de Oportunidades - WS
	 */
	public String consultarInformacoesResumo() {
		return consultarInformacoesResumoXML(null);
	}

	public String consultarInformacoesResumoXML(List<HeaderProperty> headers) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_RESUMO);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_RESUMO,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_RESUMO,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_RESUMO_RETURN)) {
				Object obj = result.getProperty(WS_RESUMO_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_RESUMO_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	/*
	 * Informações Oportunidade - Webservice
	 * 
	 */
	
	public String consultarInformacoesOportunidade(Integer codigoEstado, Integer codigoCategoria, Integer codigoVaga, Integer flag) {
		return consultarInformacoesOportunidadeXML(null, codigoEstado, codigoCategoria, codigoVaga, flag);
	}

	public String consultarInformacoesOportunidadeXML(List<HeaderProperty> headers, Integer estadoID, Integer categoriaID, Integer vagaID, Integer flag ) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_BUSCA);
		soapReq.addProperty("estadoID", estadoID);
		soapReq.addProperty("categoriaID", categoriaID);
		soapReq.addProperty("vagaID", vagaID);
		soapReq.addProperty("flag", flag);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {

			if (headers != null) {
				httpTransport.call(NAMESPACE+"/"+WS_BUSCA,soapEnvelope, headers);
			} else {
				httpTransport.call(NAMESPACE+"/"+WS_BUSCA,soapEnvelope);
			}
			SoapObject result = (SoapObject) soapEnvelope.bodyIn;
			if (result.hasProperty(WS_BUSCA_RETURN)) {
				Object obj = result.getProperty(WS_BUSCA_RETURN);
				if (obj.getClass().equals(SoapPrimitive.class)) {
					SoapPrimitive j4 = (SoapPrimitive) result.getProperty(WS_BUSCA_RETURN);
					String resultVariable = j4.toString();
					return resultVariable;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}	

	/*
	 * Gravar Estatistica - Webservice
	 * 
	 */
	
	public void gravarInformacoesEstatistica(Enviado enviado, Preferencia preferencia) {
		 gravarInformacoesEstatisticaXML(enviado, preferencia);
	}

	public void gravarInformacoesEstatisticaXML(Enviado enviado, Preferencia preferencia) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_ESTATISTICA);
		soapReq.addProperty("enviado", enviado);
		soapReq.addProperty("preferencia",preferencia);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			httpTransport.call(NAMESPACE+"/"+WS_ESTATISTICA,soapEnvelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	

	/*
	 * Gravar Precadastro - Webservice
	 * 
	 */
	
	public void gravarInformacoesPrecadastro(Preferencia preferencia) {
		 gravarInformacoesPrecadastroXML(preferencia);
	}

	public void gravarInformacoesPrecadastroXML(Preferencia preferencia) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_PRECADASTRO);
		soapReq.addProperty("preferencia",preferencia);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			httpTransport.call(NAMESPACE+"/"+WS_PRECADASTRO,soapEnvelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	


	/*
	 * Gravar Curriculo - Webservice
	 * 
	 */
	
	public void gravarInformacoesCurriculo(Preferencia preferencia, Curriculo curriculo) {
		gravarInformacoesCurriculoXML(preferencia, curriculo);
	}

	public void gravarInformacoesCurriculoXML(Preferencia preferencia, Curriculo curriculo) {
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		
		new MarshalBase64().register(soapEnvelope);
		
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_CURRICULO);
		soapReq.addProperty("preferencia",preferencia);
		soapReq.addProperty("curriculo", curriculo);
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			httpTransport.call(NAMESPACE+"/"+WS_CURRICULO,soapEnvelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	
		
		
		
		/*
		SoapSerializationEnvelope soapEnvelope = new SoapSerializationEnvelope(SoapEnvelope.VER11);
		
		new MarshalBase64().register(soapEnvelope);
		
		soapEnvelope.implicitTypes = true;
		soapEnvelope.dotNet = true;
		SoapObject soapReq = new SoapObject(NAMESPACE, WS_CURRICULO);
		soapReq.addProperty("curriculo", curriculo);
		soapReq.addProperty("preferencia", preferencia);		
		soapEnvelope.setOutputSoapObject(soapReq);
		HttpTransportSE httpTransport = new HttpTransportSE(url, timeOut);
		try {
			httpTransport.call(NAMESPACE+"/"+WS_CURRICULO,soapEnvelope);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}	*/

}


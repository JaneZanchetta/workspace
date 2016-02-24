import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

import br.univel.common.ServicoRMI;


public class Client {

	
	public static void main(String[] args) {
		Registry registry;
		try {
//			registry = LocateRegistry.getRegistry("127.0.0.1", 1818);
			registry = LocateRegistry.getRegistry("192.168.104.209", 1818);
			ServicoRMI servico = (ServicoRMI) registry.lookup(ServicoRMI.NOME);
			double a = 10.0;
			double b = 2.0;
			double retorno = servico.somar(a, b);
			System.out.println("Soma de " + a + " + " + b + " � "+ retorno) ;
			retorno = servico.subtrair(a, b);
			System.out.println("Subtraindo  " + b + " de " + a + " temos "+ retorno) ;
			retorno = servico.multiplicar(a, b);
			System.out.println("Multiplicando  " + a + " por " + b + " temos "+ retorno) ;
			retorno = servico.dividir(a, b);
			System.out.println("Dividindo  " + a + " por " + b + " temos "+ retorno) ;

		} catch (RemoteException e) {
			e.printStackTrace();
		} catch (NotBoundException e) {
			e.printStackTrace();
		}
	}
	
}

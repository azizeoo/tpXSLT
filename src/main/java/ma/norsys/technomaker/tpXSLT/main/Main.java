/**
 * 
 */
package ma.norsys.technomaker.tpXSLT.main;

import java.io.File;
import java.io.IOException;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;

import ma.norsys.technomaker.tpXSLT.IConstantes;

/**
 * @author technomaker09
 * 
 */
public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			creerHTML(IConstantes.XML_FILE_NAME, IConstantes.XSLT_FILE_NAME,
					IConstantes.HTML_FILE_NAME);
		} catch (IOException e) {
			System.out.println("IOException ");
		} catch (TransformerException e) {
			System.out.println("TransformerException ");
		}
	}
	/**
	 * 
	 * @param xml le path du fichier xml (in)
	 * @param xsl le path du ficher xslt (in)
	 * @param html le path du fichier html (out)
	 * @throws IOException
	 * @throws TransformerException
	 */
	public static void creerHTML(String xml, String xsl, String html)
			throws IOException, TransformerException {
		//r�cuperation du fichier xml et fichier xsl
		File xmlFile = new File(xml);
		File xslFile = new File(xsl);

		//cr�ation des sources en se basant sur les deux fichiers xml et xsl
		Source xmlSource = new StreamSource(xmlFile);
		Source xslSource = new StreamSource(xslFile);
		
		//creation de r�sultat pour contenir le fichier html (g�ner�)
		Result result = new StreamResult(html);

		//r�cuperation de l'instance du fabrique 'TransformerFactory'
		TransformerFactory transFact = TransformerFactory.newInstance();
		//cr�ation de transformateur
		Transformer trans = transFact.newTransformer(xslSource);
		
		//transformer
		trans.transform(xmlSource, result);
	}
}

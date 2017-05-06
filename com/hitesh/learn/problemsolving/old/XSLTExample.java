package com.hitesh.learn.problemsolving.old;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;


public class XSLTExample {
	public static void main(String args[]) throws FileNotFoundException, UnsupportedEncodingException, JAXBException {
		String filePath="C:/Users/deloitte/Desktop/feed.xml";


		//			InputStream inputStream = new FileInputStream(filePath);
		//			Reader reader = new InputStreamReader(inputStream, "UTF-16");


		File stylesheet = new File("tradosConvert.xsl");
		///Algorithms/Mar 17 2014 Export File.xml
		File datafile = new File("Apr 02 2014 Export File.xml");
		File tFile= new File("C:/Users/hitjoshi/transformedFile.xml");

		TransformerFactory factory = TransformerFactory.newInstance();

		StreamSource xslStream = new StreamSource(stylesheet);

		Transformer transformer;
		try {
			transformer = factory.newTransformer(xslStream);


			StreamSource in = new StreamSource(datafile);

			StreamResult out = new StreamResult(tFile);

			transformer.transform(in, out);	                   
		}
		catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (TransformerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("Transform Completed and jax B started");

		XSLTExample example = new XSLTExample();

		Translations t=example.getTermBaseTranlations(tFile);
		List<Translation> enList=new ArrayList<Translation>();
		System.out.println("Size after,,...."+t.getTranslation().size());
		//datafile.delete();
		//tFile.delete();


	}

	private  Translations  getTermBaseTranlations(File file) throws JAXBException, FileNotFoundException, UnsupportedEncodingException
	{
		Translations translations=null;
		//Date cacheUploadStartTime = new Date();
		JAXBContext jc = JAXBContext.newInstance(ObjectFactory.class);	
		Unmarshaller unmarshaller  = jc.createUnmarshaller();
		InputStream inputStream = new FileInputStream(file);
		Reader reader = new InputStreamReader(inputStream, "UTF-16");
		//logger.info("StaticContentCache.updateCacheFromTermBase Parsing Starts");
		translations = (Translations)unmarshaller.unmarshal(reader);
		System.out.println("English translation in XML----");
		int j=0;
		for(Translation t1:translations.getTranslation())
		{
			
			if(t1.getName().startsWith("#pps_")&& t1.getLang().equals("en") )
			{
				System.out.println("Name ---- Content---LC----Reg---CC  "+t1.getName()+"----"+t1.getContent()+"-----"+t1.getLang()+"-----"+t1.getRegion()+"----"+t1.getCc());
			j++;
			}
		}
		System.out.println("total english translations"+j);
		
		/*List<Translation> enList=new ArrayList<Translation>();
		for(Translation t:translations.getTranslation())
		{
			if(t.getLang()=="en")
			{
				enList.add(t);
			}
		}

		System.out.println("English Size"+enList.size());
		File English= new File("C:/Users/hitjoshi/ENGLISH_TRANSLATIONS.txt");
		if (!English.exists()) {

			BufferedWriter bw1 =null;
			try {
				English.createNewFile();
				FileOutputStream fostream = new FileOutputStream(English);

				OutputStreamWriter out = new OutputStreamWriter(fostream,"UTF-16");

				bw1 = new BufferedWriter(out);

				for(Translation t2:enList)
				{
					bw1.write("------ Record Starts--------------");
					bw1.newLine();
					bw1.write("cc  "+t2.getCc());
					bw1.newLine();
					bw1.write("lc "+t2.getLang());
					bw1.newLine();
					bw1.write("region "+t2.getRegion());
					bw1.newLine();
					bw1.write("name "+t2.getName());
					bw1.newLine();
					bw1.write("value "+t2.getContent());
					bw1.newLine();
					bw1.write("------ Record Ends--------------");
					bw1.newLine();
				}


			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			finally
			{
				try {
					bw1.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

*/			//logger.info("StaticContentCache.updateCacheFromTermBase Parsing Ends. Time Taken"	+ (new Date().getTime() - cacheUploadStartTime.getTime()));
			Set<Translation> noDuplicateTransSet= new HashSet<Translation>();				
			noDuplicateTransSet.addAll(translations.getTranslation());

			List<Translation> oldList= new ArrayList(translations.getTranslation());

			System.out.println("Old List size"+oldList.size());

			System.out.println("Translation List size before"+translations.getTranslation().size());

			translations.getTranslation().clear();

			translations.getTranslation().addAll(noDuplicateTransSet);
			System.out.println("Translation List size after"+translations.getTranslation().size());
			System.out.println("transaction Set---- "+noDuplicateTransSet.size());
			System.out.println("Old list size later----"+oldList.size());
		/*	for(Translation t1:noDuplicateTransSet)
			{
				oldList.remove(t1);
			}
			System.out.println("Duplicates-----"+oldList.size());
			File duplicates= new File("C:/Users/hitjoshi/Duplicates.txt");
			if (!duplicates.exists()) {

				BufferedWriter bw =null;
				try {
					duplicates.createNewFile();
					FileOutputStream fostream = new FileOutputStream(duplicates);

					OutputStreamWriter out = new OutputStreamWriter(fostream,"UTF-16");

					bw = new BufferedWriter(out);

					for(Translation t2:oldList)
					{
						bw.write("------ Record Starts--------------");
						bw.newLine();
						bw.write("cc  "+t2.getCc());
						bw.newLine();
						bw.write("lc "+t2.getLang());
						bw.newLine();
						bw.write("region "+t2.getRegion());
						bw.newLine();
						bw.write("name "+t2.getName());
						bw.newLine();
						bw.write("value "+t2.getContent());
						bw.newLine();
						bw.write("------ Record Ends--------------");
						bw.newLine();
					}


				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

				finally
				{
					try 
					{
						bw.close();
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}


			}
			*/
	
		return translations;
	}
}
import com.typesafe.config.ConfigFactory
import utils.Helper.{buildSeq,differ}




object Main extends App {

  val appConfiguration = ConfigFactory.load()
  val path = appConfiguration.getString("common.xml.path")

  val person = buildSeq(path)

  //process the list
  val theOldest = person.reduce((a,b)=> if(a._2>b._2) a else b)
  val theYoungest = person.reduce((a,b)=> if(a._2<b._2) a else b)
  val theLongestName = person.reduce((a,b)=> if(a._1.length>b._1.length) a else b)
  val theShortestName =   person.reduce((a,b)=> if(a._1.length<b._1.length) a else b)
  val meanAge = person.map(_._2).reduce((a,b)=>a+b)/person.size


  //Print results
  println(person)
  println(differ(person))
  println(theOldest)
  println(theYoungest)
  println(theLongestName)
  println(theShortestName)
  println(meanAge)

}
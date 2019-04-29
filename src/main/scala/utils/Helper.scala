package utils

import scala.xml.XML

/***
  * this object is used to facilitate some functions
  */
object Helper {

  def buildSeq(path: String): Seq[(String,Int)]={
    //load xml file
    val users = XML.loadFile(path)
    //load names
    val names = (users \\ "name" ).map(_.text)
    //load ages
    val ages = (users \\ "age" ).map(_.text)
    //build a list of pairs(name:String , age:Int)
    (names zip ages).map(x=>x._1->x._2.toInt)

  }

  //a function to get the biggest difference between two consecutive elements
  def differ(seq: Seq[(String,Int)]):Int = {
    var firstAge = seq(1)._2
    val newPerson = seq.drop(1).map(_._2)
    var maxDif = -999
    newPerson.foreach(a=>{
      val dif = firstAge - a
      if(dif>maxDif) maxDif=dif;
      firstAge=a
    })
    maxDif
  }
}

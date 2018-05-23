////////////////////Neophyts guide chapter 4 ////////////////////////


val wordFrequencies = ("habitual", 6) :: ("and", 56) :: ("consuetudinary", 2) :: ("additionally", 27) :: ("homely", 5) :: ("society", 13) :: Nil
  

//version 1 
def wordsWithoutOutliers(wordFrequencies: Seq[(String, Int)]): Seq[String] = wordFrequencies.filter(x => x._2 > 3 && x._2 < 25).map(_._1)

//version 2 
def wordsWithoutOutliers2(wordFrequencies: Seq[(String, Int)]): Seq[String] = 
	wordFrequencies.filter{case (_,s)=> s > 3 && s < 25} map {case (w,_)=> w}

wordsWithoutOutliers2(wordFrequencies)

///improving with partial function
val pf: PartialFunction[(String, Int), String] = {
  case (word, freq) if freq > 3 && freq < 25 => word
}

wordFrequencies.collect(pf)


//final version

def wordsWithoutOutliers3(wordFrequencies: Seq[(String, Int)]): Seq[String] = 
	wordFrequencies.collect { case(word,freq) if freq > 3 && freq < 25 => word }


wordsWithoutOutliers3(wordFrequencies)

package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            val strArr = resources.getStringArray(R.array.colors)
            val sb = StringBuilder()
            val intArr= resources.getIntArray(R.array.intArr)
            binding.textView.text = intArr.contentToString()
            /*
            strArr.sort()   // 오름차순
            strArr.sortDescending() // 내림차순

            val newArr = strArr.sortedArray()

            val chArr = Array(strArr.size){i -> strArr[i][0]}
            chArr.forEach { sb.append("${it}-${it.code}, ") }
            binding.textView.text = sb.toString()

            val c0 = (strArr[0])[0]
            val c1 = strArr[1][0]
            val c2 = strArr[2][0]
            binding.textView.text = "${"c0 = ${c0.code}, c1=${c1.code}, c2 = ${c2.code}"}"
            */


/*            // arrayOf => 원소의 개수가 한정적이고, 각 원소가 다른값을 가지고, 일관성이 없을때
             stringArrayOf 는 불가능함
            // Array => 원소의 개수 많고, 일정한 초기값을 가질 때
            val strArr: Array<String> = arrayOf<String>("red", "green", "blue")
            val strArr2: Array<Int> = Array(10, { it })
            val strArr3: Array<String> = Array<String>(strArr.size) { "Color ${strArr[it]}" }
            val boolArray: BooleanArray = booleanArrayOf(true, false, false);
            binding.textView.text = strArr.contentToString()


             array => 정적 자료구조
             listOf => 불변 리스트, mutableListOf => 가변 리스트
            val strList = listOf<String>("red", "green", "blue")
            val strList2 = mutableListOf<String>("red", "green", "blue")

            binding.textView.text = strArr3.contentToString()
            binding.textView.text = "${strList.first()}, ${strList.last()}"
            binding.textView.text = "${strList.filter { it.length == 3 }}"
            binding.textView.text = "${strList.map { ele -> "Color $ele" }}"

            // 리스트 안의 요소의 길이가 4보다 작은 요소 존재시 false 보여줌
            binding.textView.text = "${strList.none{it.length <4}}"


            val strArr: Array<String> = resources.getStringArray(R.array.colors)
            val sb = StringBuilder()
            strArr.forEach { sb.append("$it! ") }
            strArr.forEachIndexed { idx, ele -> sb.append("${strArr[idx]} = $ele, ")

            for(ele in strArr){
            sb.append("$ele ")
            }
            for (idx in strArr.indices){
            sb.append("${strArr[idx]}, ")
            }

            val iter : Iterator<String> = strArr.iterator()
            while (iter.hasNext()){
                sb.append("${iter.next()}, ")
            }
            binding.textView.text = sb.toString()
            binding.textView.text = strArr.contentToString()*/

        }

    }
}
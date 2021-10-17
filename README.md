# RecyclerViewCarousel
Carousel animation using recyclerview with bottom aligned in Android


Carousel animation is generally a common implementation with viewpager.
With recyclerview this is something different. I took help from this link
https://stackoverflow.com/a/41307581/8101634 and implemented the same with recyclerview.


![image](https://user-images.githubusercontent.com/92637007/137620149-b5177141-7b88-43b7-8518-0a3130c8c133.png)


By commenting out this line in CarouselLayoutManager 

child.pivotY = child.height.toFloat()

you will get the result as below image.

![image](https://user-images.githubusercontent.com/92637007/137620384-f71e8913-f682-4dcf-9e1b-21551b7b0966.png)



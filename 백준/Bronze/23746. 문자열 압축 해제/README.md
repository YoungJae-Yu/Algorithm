# [Bronze I] 문자열 압축 해제 - 23746 

[문제 링크](https://www.acmicpc.net/problem/23746) 

### 성능 요약

메모리: 18416 KB, 시간: 180 ms

### 분류

구현, 문자열

### 제출 일자

2025년 7월 12일 22:35:48

### 문제 설명

<p>특정 소문자 문자열 패턴을 대문자 한 글자로 압축하는 프로그램 SPC(String Pattern Compressor)가 있다.</p>

<p>예를 들어, 다음과 같은 방법으로 압축하는 경우, “<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mtext class="mjx-n"><mjx-c class="mjx-c61"></mjx-c><mjx-c class="mjx-c61"></mjx-c><mjx-c class="mjx-c62"></mjx-c><mjx-c class="mjx-c62"></mjx-c><mjx-c class="mjx-c61"></mjx-c><mjx-c class="mjx-c61"></mjx-c><mjx-c class="mjx-c61"></mjx-c><mjx-c class="mjx-c63"></mjx-c></mjx-mtext></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mtext>aabbaaac</mtext></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\text{aabbaaac}$</span></mjx-container>”는 “<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mtext class="mjx-n"><mjx-c class="mjx-c41"></mjx-c><mjx-c class="mjx-c42"></mjx-c><mjx-c class="mjx-c41"></mjx-c><mjx-c class="mjx-c43"></mjx-c></mjx-mtext></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mtext>ABAC</mtext></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\text{ABAC}$</span></mjx-container>”로 압축된다.</p>

<table class="table table-bordered table-center-30">
	<tbody>
		<tr>
			<td style="text-align: center;">소문자 문자열 패턴</td>
			<td style="text-align: center;">대문자</td>
		</tr>
		<tr>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mtext class="mjx-n"><mjx-c class="mjx-c61"></mjx-c><mjx-c class="mjx-c61"></mjx-c></mjx-mtext></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mtext>aa</mtext></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\text{aa}$</span> </mjx-container></td>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mtext class="mjx-n"><mjx-c class="mjx-c41"></mjx-c></mjx-mtext></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mtext>A</mtext></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\text{A}$</span> </mjx-container></td>
		</tr>
		<tr>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mtext class="mjx-n"><mjx-c class="mjx-c62"></mjx-c><mjx-c class="mjx-c62"></mjx-c><mjx-c class="mjx-c61"></mjx-c></mjx-mtext></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mtext>bba</mtext></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\text{bba}$</span> </mjx-container></td>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mtext class="mjx-n"><mjx-c class="mjx-c42"></mjx-c></mjx-mtext></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mtext>B</mtext></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\text{B}$</span> </mjx-container></td>
		</tr>
		<tr>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mtext class="mjx-n"><mjx-c class="mjx-c63"></mjx-c></mjx-mtext></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mtext>c</mtext></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\text{c}$</span> </mjx-container></td>
			<td style="text-align: center;"><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mtext class="mjx-n"><mjx-c class="mjx-c43"></mjx-c></mjx-mtext></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mtext>C</mtext></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$\text{C}$</span> </mjx-container></td>
		</tr>
	</tbody>
</table>

<p>압축 프로그램과 압축된 문자열이 주어지면, 압축되기 전 문자열의 일부를 출력하는 프로그램을 작성하시오.</p>

### 입력 

 <p>첫 번째 줄에 압축 방법의 개수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>이 주어진다. (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="4"><mjx-c class="mjx-c32"></mjx-c><mjx-c class="mjx-c36"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>N</mi><mo>≤</mo><mn>26</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \le N \le 26$</span></mjx-container>)</p>

<p>두 번째 줄부터 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N$</span></mjx-container>개의 줄에 소문자 문자열 패턴과 대응되는 대문자가 공백으로 구분되어 주어진다. 각 소문자 문자열 패턴의 길이는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1\,000$</span></mjx-container>을 넘지 않으며, 같은 대문자는 두 번 이상 주어지지 않는다.</p>

<p><mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"> <mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D441 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="3"><mjx-c class="mjx-c2B"></mjx-c></mjx-mo><mjx-mn class="mjx-n" space="3"><mjx-c class="mjx-c31"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>N</mi><mo>+</mo><mn>1</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$N+1$</span></mjx-container>번째 줄에 압축된 문자열이 주어진다. 압축된 문자열 길이는 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mstyle><mjx-mspace style="width: 0.167em;"></mjx-mspace></mjx-mstyle><mjx-mn class="mjx-n"><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c><mjx-c class="mjx-c30"></mjx-c></mjx-mn></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mstyle scriptlevel="0"><mspace width="0.167em"></mspace></mstyle><mn>000</mn></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1\,000$</span></mjx-container>을 넘지 않는다.</p>

<p>마지막 줄에 두 정수 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container>와 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D438 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>E</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$E$</span></mjx-container>가 주어진다. (<mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mn class="mjx-n"><mjx-c class="mjx-c31"></mjx-c></mjx-mn><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo><mjx-mi class="mjx-i" space="4"><mjx-c class="mjx-c1D438 TEX-I"></mjx-c></mjx-mi><mjx-mo class="mjx-n" space="4"><mjx-c class="mjx-c2264"></mjx-c></mjx-mo></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mn>1</mn><mo>≤</mo><mi>S</mi><mo>≤</mo><mi>E</mi><mo>≤</mo></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$1 \le S \le E \le $</span></mjx-container> (압축되기 전 문자열 길이))</p>

### 출력 

 <p>압축되기 전 문자열의 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D446 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>S</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$S$</span></mjx-container>번째 문자에서 <mjx-container class="MathJax" jax="CHTML" style="font-size: 109%; position: relative;"><mjx-math class="MJX-TEX" aria-hidden="true"><mjx-mi class="mjx-i"><mjx-c class="mjx-c1D438 TEX-I"></mjx-c></mjx-mi></mjx-math><mjx-assistive-mml unselectable="on" display="inline"><math xmlns="http://www.w3.org/1998/Math/MathML"><mi>E</mi></math></mjx-assistive-mml><span aria-hidden="true" class="no-mathjax mjx-copytext">$E$</span></mjx-container>번째 문자까지 출력한다.</p>


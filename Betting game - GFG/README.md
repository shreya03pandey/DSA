# Betting game
## Easy
<div class="problem-statement">
                <p></p><p><span style="font-size:18px">You are involved in a betting game whose rules are as follows :<br>
<strong>a)</strong> If you win a round, the bet amount will be added to your current sum and next bet amount will become $1;<br>
<strong>b)</strong> If you lose a round, the bet amount will be reduced from your current&nbsp;sum and next bet will become twice the previous.<br>
<strong>c)</strong> game ends either when all the rounds are complete or when you don't have sufficient sum.<br>
Initially, you are given with a string <strong>result</strong> consisiting of characters from the set {'W',&nbsp;'L'},&nbsp;where 'W' indicates a win and 'L' indicates a loss, and initial sum is 4. Initial bet amount for the 1st round&nbsp;will be $1.</span></p>

<p><span style="font-size:18px">You need to find and print the amount at the end of the game (final sum) and in case you do not have&nbsp;enough money in between the game to play the next round,&nbsp;then return -1.</span></p>

<h3><span style="font-size:18px"><strong>Example 1:</strong></span></h3>

<pre><span style="font-size:18px"><strong>Input: </strong>
result = WL 
<strong>Output:</strong> 4 
<strong>Explaination: </strong>At first you win the game so 
currently have 4+1 = $5 and the bet is $1.Now 
you loss this bet and the final balance is $4.</span></pre>

<h3><span style="font-size:18px"><strong>Example 2:</strong></span></h3>

<pre><span style="font-size:18px"><strong>Input: 
result = </strong>WLWLLLWWLW 
<strong>Output: </strong>-1
<strong>Explaination: </strong>When you reach the starting of
the three consecutive losing streak you have
balance $6 and bet is $1. After first loss in
this streak you have balance $5 and bet $2.
After second loss in this streak you have
balance $3 and bet is $4. Now see that your
balance is lesser than the next bet. So you
cannot continue playing. So the answer is -1.</span></pre>

<p><span style="font-size:18px"><strong>Your Task:&nbsp;</strong></span></p>

<p><span style="font-size:18px">You don't need to read input or print anything. Your task is to complete the function&nbsp;<strong>betBalance()</strong>&nbsp;which takes the string <strong>result&nbsp;</strong>as input parameter&nbsp;and returns the balance after the sequence of win or lose. If you cannot carry betting in between then return <strong>-1&nbsp;</strong></span></p>

<p><span style="font-size:18px"><strong>Expected Time Complexity:</strong> O(|result|)<br>
<strong>Expected Auxiliary Space:</strong> O(1)</span></p>

<p><span style="font-size:18px"><strong>Constraints:</strong></span></p>

<p><span style="font-size:18px">1 ≤ |result| ≤ 10000</span></p>
 <p></p>
            </div>
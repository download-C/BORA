<div class="join_row join_birthday">
	<h3 class="join_title">
		<label for="yy">생년월일</label>
	</h3>
	<div class="bir_wrap">
		<div class="bir_yy">
			<span class="ps_box"> 
				<input type="text" id="yy"
					placeholder="년(4자)" aria-label="년(4자)" class="int" maxlength="4">
			</span>
		</div>
		<div class="bir_mm">
			<span class="ps_box"> <select id="mm" class="sel"
				aria-label="월">
					<option value="">월</option>
					<option value="01">1</option>
					<option value="02">2</option>
					<option value="03">3</option>
					<option value="04">4</option>
					<option value="05">5</option>
					<option value="06">6</option>
					<option value="07">7</option>
					<option value="08">8</option>
					<option value="09">9</option>
					<option value="10">10</option>
					<option value="11">11</option>
					<option value="12">12</option>
			</select>
			</span>
		</div>
		<div class=" bir_dd">
			<span class="ps_box"> <input type="text" id="dd"
				placeholder="일" aria-label="일" class="int" maxlength="2"> <label
				for="dd" class="lbl"></label>
			</span>
		</div>
	</div>
	<span class="error_next_box" id="birthdayMsg" style="display: none"
		aria-live="assertive"></span>
</div>
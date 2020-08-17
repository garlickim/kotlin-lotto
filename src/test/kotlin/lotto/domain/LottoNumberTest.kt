package lotto.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class LottoNumberTest {

    @Test
    fun `로또 번호는 1-45사이의 숫자다`() {
        val lottoNumber: LottoNumber = LottoNumber.get(1)
        assertThat(lottoNumber).isInstanceOf(LottoNumber::class.java)
    }

    @Test
    fun `로또는 6자리 숫자다`() {
        val lottoNumbers: Set<LottoNumber> = LottoNumber.generateNumbers()
        assertThat(lottoNumbers.size).isEqualTo(6)
    }
}

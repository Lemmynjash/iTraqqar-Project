package org.traccar.protocol;

import org.junit.Test;
import org.traccar.ProtocolTest;
import org.traccar.model.Position;

public class HuabaoProtocolDecoderTest extends ProtocolTest {

    @Test
    public void testDecode() throws Exception {

        var decoder = inject(new HuabaoProtocolDecoder(null));

        verifyNull(decoder, binary(
                "7e010200204f07788ef67601824f4459344f544d314d4459774d4441314d444977626d5633553235536457786cba7e"));

        verifyPosition(decoder, binary(
                "7e0200004107904226220608ca0000010000000010031dac0d004864f30000000000002212291003220104000179a7300107310100eb17000300e151000300e304000b00d801041edf340000306b007e"));

        verifyPosition(decoder, binary(
                "7E020000FE069223000241002E00000000000C0003015A98F806C8A1260013000000E622082617464401040000017F02020001030200002504000000002A0200002B0400000000300117310112E306000005890000F3B4000202000000030202F2000402375F00050400000000000602000C000702000C000801320009020072000B020035000C020050000D020176000E0122000F018A00501B4C46504D34414350584731413337303937000000000000000000000052040000000C01000200010101040000000001020200010103040000000101040203E7010C02000E010D020000010E02059B010F020072011002387001110200000112020000011302000001140200000116020000D17E"));

        verifyPositions(decoder, binary(
                "7E021001A2010036526447000A3B00000000000000010158F52206C916B0000000000000161118110121661D019431000B0000CF47006931000B000058A4006930000B0000882400693B00000000000000010158F52206C916B0000000000000161118110122661D019431000B0000CF47006931000B000058A4006930000B0000882400693B00000000000000010158F52206C916B0000000000000161118110123661D019431000B0000CF47006931000B000058A4006930000B0000882400693B00000000000000010158F52206C916B0000000000000161118110124661D019431000B0000CF47006931000B000058A4006930000B0000882400691C00000000000000010158F52206C916B00000000000001611181101253B00000000000000010158F52206C916B0000000000000161118110126661D019431000B0000CF47006931000B000058A4006930000B0000882400693B00000000000000010158F52206C916B0000000000000161118110127661D019431000B0000CF47006931000B000058A4006930000B0000882400691C00000000000000010158F52206C916B0000000000000161118110128F57E"));

        verifyAttribute(decoder, binary(
                "7e02000042012291302260198f00000000800c012300d2651605ff3188001e0000000022102510310003020000a70400000000ac040000012ce5020003e60b03bc572900ce2eef183200e7030000005c7e"),
                Position.PREFIX_TEMP + 3, -17.094117647058823);

        verifyAttribute(decoder, binary(
                "7E0200008201215233475100030000000000000003015A7F6106CF8CEC003D0000000021071311481901040000005630011931011AE10200755D3D0601CC0024990A7dA0032301CC002499099B2941FC01CC002499099B29430B01CC0024990A7dA0290601CC0024990A7dA015FD01CC0026220994506BFFFE157C010400000001F10C000000000000000000000000997E"),
                Position.KEY_ALARM, Position.ALARM_ACCELERATION);

        verifyAttribute(decoder, binary(
                "7e020000340551231425560568000000000400000201618a9706c320e100410000002722060816261501040000015d300115310105eb0a000300e164000300e301957e"),
                Position.KEY_BATTERY_LEVEL, 100);

        verifyNull(decoder, buffer(
                "(794104004140,1,001,BASE,2,TIME)"));

        verifyAttribute(decoder, binary(
                "7E02000053200002604323004800000000000C00000158B91406CB7007006B00000000220512101138010400000F2803020000250400000000300114310100E30100D50E0100026043232795980277530030E50400000000E7020FC8E8020E83AB7E"),
                "lock1Locked", false);

        verifyPosition(decoder, binary(
                "7E0900005A4E5DE66FBA2200C4F02204280610090002010D052B0150052C0400129009052D016B052E014F05300231BA053502000005360203B8053802000005390200AD053D0201EA05440150054604009899D90545040000001E000C00030160A85C06D1C1389C7E"));

        verifyNull(decoder, binary(
                "7E01000021013345678906000F002C012F373031313142534A2D4D3742203030303030303001D4C1423838383838B47E"));

        verifyAttribute(decoder, binary(
                "7E020000480123456789010013000000800000000301597BC506CBFF6600EB00000155210726203531010400000000EB24000C00B28986047701207027150200060089FFFFEFFF0004002D0E10000600C5FFFFFFEF697E"),
                Position.KEY_ALARM, Position.ALARM_LOW_BATTERY);

        verifyAttribute(decoder, binary(
                "7e0200008e01917159043700b300000000800000030158990606ca0fd7000400000000211129111705010400000000cc14383938363037423831303230393031363239363830010d8001aa81021388820200858301148401aa8502189b8601338702007e8801338901148a0200998b1131323334353637383941424344454647488c04000200a88d0200828e0114a00b50353338662c5530323966037e"),
                Position.KEY_DTCS, "P538f U029f");

        verifyPosition(decoder, binary(
                "7E020000830191715904370A2E00000000800000030158991806CA0FEB00040000010D211108194050010400000003CC14383938363034373831303230373033313836303830011A8001AA810213888202007A8301148401AA8502189B8601338702007D028801338901148A0200998B1131323334353637383941424344454647488C04000200A88D0200828E0114A0002E7E"));

        verifyPosition(decoder, binary(
                "7e0200007c0191718447540dcd000000008000000b029eabc204ba78510004000000042111182321120104000017f6cc14383933303237323037303339333033383732373130011d800134810204718202008283010e84017b85021ae986012f870201788901038b114a4e31424a314352364b573333363533358c040008dcb68d02018c8e013da000c07e"));

        verifyNotNull(decoder, binary(
                "7e207002940121523001530047210927151009000e002d80ac210927151010000e002d80ab210927151011000e002d80ac210927151012000e002e80ab210927151013000e002d80ab210927151014000e002d80ab210927151015000e002d80ab210927151016000e002d80aa210927151017000e002e80ab210927151018000e002d80ab210927151019000e002e80ac210927151020000e002d80ab210927151021000e002d80ab210927151022000d002d80ac210927151023000e002d80ac210927151024000e002e80ab210927151025000e002e80b0210927151026000e002e80ab210927151027000e002d80ab210927151028000e002e80b0210927151029000e002d80b0210927151030000e002e80ab210927151031000e002d80ab210927151032000e002d80aa210927151033000e002d80ab210927151034000e002d80ab210927151035000e002d80ab210927151036000e002d80ab210927151037000e002d80ab210927151038000e002d80b0210927151039000d002e80aa210927151040000e002d80ab210927151041000e002d80a5210927151042000e002e80ab210927151043000e002d80aa210927151044000e002d80ab210927151045000e002d80ab210927151046000e002d80ac210927151047000e002e80ab210927151048000e002e80a5210927151049000e002d80ab210927151050000e002d80ab210927151051000e002d80ab210927151052000e002d80ab210927151053000e002d80aa210927151054000e002e80b0210927151055000e002e80ab210927151056000e002d80ac210927151057000e002e80ab210927151058000e002d80ab210927151059000e002e80ab210927151100000e002d80ab210927151101000e002e80aa210927151102000e002d80a6210927151103000e002e80a5847e"));

        verifyNotNull(decoder, binary(
                "7e07040226046110426684002b000601005f0000000000000000000000000000000000000000000021031410530001040000000030011b310101e4020064e50101e60100e7080000000000000000eb2101cc00253510260100000000000000000000000000000000000000000000000000005f00000000004c0001000000000000000000000000000021031410531401040000000030011f310103e4020064e50101e60100e7080000000000000000eb2101cc0025351026012535100f32263d11f931000000000000000000000000000000005f00000000004c0001000000000000000000000000000021031410534001040000000030011f310104e4020064e50101e60100e7080000000000000000eb2101cc002535102601263d11f92d0000000000000000000000000000000000000000005f00000000004c00010000000000000000000000000000210314105350010400000000300118310104e4020064e50101e60100e7080000000000000000eb2101cc002535102601263d11f92e25350f6f2c263d120d2c00000000000000000000005f00000000004c0001000000000000000000000000000021031410540001040000000030011d310105e4020064e50101e60100e7080000000000000000eb2101cc002535102601263d11f93025350f6f2e263d120d2e00000000000000000000003c00000000004c0003015ae3e106c82ab900000010010b21031410540901040000000030011b310105e4020064e50101e60100e7080000000000000000f97e"));

        verifyAttribute(decoder, binary(
                "7e02000033421030000018004c000200000004000201556dcb06c4d41d000c00f100fc210118095853010400000000fe0140ff0c01cc000000002694000055d87a7e"),
                Position.KEY_ALARM, Position.ALARM_TAMPERING);

        verifyAttribute(decoder, binary(
                "7e02000033202011200010001300020000000400020158b30006c93ee5002000000000201127162937010400000000fe0145ff0c01cc00000000263300000f3e627e"),
                Position.KEY_BATTERY_LEVEL, 69);

        verifyPosition(decoder, binary(
                "7e0200002e202000129707001c0000000000001c0601a2f0a8091f0bf00000000000ed201103031733000000000000000000780000000018000000267e"));

        verifyAttribute(decoder, binary(
                "7e070400db07904116875014480003010046000000000000000b020057d40072fb9c0064017200f220090215230301040000092930011f31010ceb1c000c00b28921200272401241734f00060089ffffffef000400ce1d460046000000000000000b0200570c0072fdb2005f013600ee20090215230801040000092a30011f31010ceb1c000c00b28921200272401241734f00060089ffffffef000400ce1e800046000000000000000b020056ac0072fe9b005a00d200ec20090215231301040000092a30011b31010ceb1c000c00b28921200272401241734f00060089ffffffef000400ce1e35d77e"),
                Position.KEY_POWER, 74.94);

        verifyAttribute(decoder, binary(
                "7e550104337401903111850622072002454206133574075359513a0000080100000001aa00005ded05e203000000000c06005affb5ffb40a0302dc65100100137e"),
                Position.KEY_CHARGE, true);

        verifyAttribute(decoder, binary(
                "283734303139303331313138352c312c3030312c454c4f434b2c332c35323934333929"),
                Position.KEY_RESULT, "(740190311185,1,001,ELOCK,3,529439)");

        verifyPosition(decoder, binary(
                "7e55028436740190311185091607200239270613212607536108630000170a000000014600005ded05e203000000000b010d0c06005b003e00ab0a0302dc65100100a37e"));

        verifyPosition(decoder, binary(
                "7E550100287001608180000127061008045322332880113555602E050031010000000608000010931435010002000300030100051B7E"));

        verifyAttribute(decoder, binary(
                "7E0200005C03204187290418C70000000000040003015AFC8D06D134D600000000000020040110063457080000000000000000010400000002530901000000000000000030010F310106EB1D000800233030312E3437000A000300000000000000000005000101A500357E"),
                "fuel2", 1.47);

        verifyAttribute(decoder, binary(
                "7E0200005C087034547007000B0000000000040003015A7CEF06CF8A84000000000000200108064451570800000000000000000104000000005309010000000000000000300113310109EB1D000800233030302E3838000A0003001A00000000000000050001037700B27E"),
                "fuel1", 88.7);

        verifyAttribute(decoder, binary(
                "7e02000054086031592715006e0000000000000002015a3c1a06c8733800000000000019103022183633362a4d30302c34352c31313338363030526f79314f70656e26303030303030303030303030263132333435363738393031323334353623ff7e"),
                Position.KEY_BATTERY, 3.86);

        verifyPosition(decoder, binary(
                "7e0200004e08026300003006480000000000000007021477d90841920700000000005019110515194001040000167130011631010cd00400000400d3020027d4013fd6143839363130313832303030343833363532383330da0104897e"));

        verifyPosition(decoder, binary(
                "7e020000400303000002280042000000000000000301618ab406c31ec800000000000518092116145701040000047830011031010aeb16000c00b28986011780108622216500060089ffffffffc37e"));

        verifyPosition(decoder, binary(
                "7E0200002A013833501744001900000000000000C201597FA806CC01580080000000081508180721210104000002F502020000030200009F7E"));

        verifyPositions(decoder, binary(
                "7E0704014301356777777707F5000801002600000000000000030159741206CBFD5001720000000116052709062401040000001D03020000002600000000000000030159746606CBFD50016B0000000116052709065301040000001D0302000000260000000000000003015975E406CBFE58013F0000000116052709072701040000001D0302000000260000000000000003015976DE06CBFF10012E0000000116052709075601040000001D0302000000260000000000000003015976BC06CBFED0012D0000000116052709083001040000001D0302000000260000000000000003015976FE06CBFEC001080000000116052709090001040000001D0302000000260000000000000003015976FE06CBFE7800FC0000000116052709093301040000001D0302000000260000000000000003015977A606CBFF3001080000000116052709100201040000001D030200001F7E"));

        verifyAttributes(decoder, binary(
                "7E0200002F01357888888800B60000000000000003015972B406CBF6B802230000000116061317571301040000000003020000EB0700050001016708B37E"));

        verifyPositions(decoder, binary(
                "7E070400F30303000002450064000401003A000000000000000301618AC606C31F20000000000029180514202847010400000000EB16000C00B28986061708003732585700060089FFFFFFFE003A000000000000000301618AE806C31EB800000000009F180514202917010400000000EB16000C00B28986061708003732585700060089FFFFFFFE003A000000000000000301618AE806C31EB800000000009F180514202947010400000000EB16000C00B28986061708003732585700060089FFFFFFFE003A000001000000080301618AE806C31EB800000000009F180514203006010400000000EB16000C00B28986061708003732585700060089FFFFFFFED77E"));

        verifyPosition(decoder, binary(
                "7e02000054093037612710000700000000000000010223aca000dc9dd800000000000017121417122133362a4d30302c34352c31313336393042383030313233303026303030303030303030303030263132333435363738393031323334353623897e"));

        verifyPosition(decoder, binary(
                "7e0200002c00160128561400020000000000040001005de1f7065c6cef00000000000017011710044201040000a9002a02000030011b3101030c7e"));

        verifyPosition(decoder, binary(
                "7e0200002c00160128561400030000000000040007005de13c065c6cdb00160000000017011710054201040000a9002a02000030011b310104e47e"));

        verifyNull(decoder, binary(
                "7e0100002d0141305678720024002c012f373031313142534a2d41362d424400000000000000000000003035363738373201d4c14238383838386d7e"));

        verifyNull(decoder, binary(
                "7E0100002D013511221122000500000000373031303748422D52303347424400000000000000000000003233363631303402CBD5424136383630387E"));

        verifyNull(decoder, binary(
                "7e0100002d007089994489002800000000000000000048422d523033474244000000000000000000000031393036373531024142433030303030d17e"));

        verifyNull(decoder, binary(
                "7E0102000E013511221122000661757468656E7469636174696F6E3F7E"));

        verifyPosition(decoder, binary(
                "7E02000032013511221122000700000000000C000301578CC006CA3A5C00470000000014072317201501040000000030011631010BD07E"));

        verifyNull(decoder, binary(
                "7E010200100940278494700084323031313131303831313333323139369F7E"));

        verifyNull(decoder, binary(
                "7e010000190940278494700012000000000000000000000000000000000000094027849470000a7e"));

        verifyPosition(decoder, binary(
                "7e0200002e094027587492000a000000010000000a03083db7001329f3000000140000130412164952010400000012360a0002341502cb0c20085c107e"));

        verifyPosition(decoder, binary(
                "7e020000220014012499170007000000000000400e012af16f02cbd2ba000000000000150101194257010400000077a97e"));

        verifyNull(decoder, binary(
                "7e0002000004304832546500b7ca7e"));

    }

}
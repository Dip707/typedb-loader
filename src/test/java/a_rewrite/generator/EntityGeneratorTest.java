package a_rewrite.generator;

import a_rewrite.config.Configuration;
import a_rewrite.util.GraknUtil;
import a_rewrite.util.Util;
import com.vaticle.typedb.client.api.connection.TypeDBClient;
import com.vaticle.typedb.client.api.connection.TypeDBSession;
import com.vaticle.typedb.client.api.connection.TypeDBTransaction;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;

public class EntityGeneratorTest {

    @Test
    public void genericEntityTest() throws IOException {
        String dbName = "entity-generator-test";
        String sp = new File("src/test/resources/1.0.0/generic/schema.gql").getAbsolutePath();
        TypeDBClient client = GraknUtil.getClient("localhost:1729");
        GraknUtil.cleanAndDefineSchemaToDatabase(client, dbName, sp);

        String dcp = new File("src/test/resources/1.0.0/generic/dc.json").getAbsolutePath();
        Configuration dc = Util.initializeDataConfig(dcp);
        assert dc != null;
        ArrayList<String> entityKeys = new ArrayList<>(List.of("entity1", "entity2", "entity3"));
        TypeDBSession session = GraknUtil.getDataSession(client, dbName);
        for (String entityKey : entityKeys) {
            for (int idx = 0; idx < dc.getEntities().get(entityKey).getAttributes().length; idx++) {
                setEntityHasAttributeConceptType(entityKey, idx, dc, session);
            }
        }
        session.close();
        client.close();

        String dp = new File("src/test/resources/1.0.0/generic/entity1.tsv").getAbsolutePath();
        EntityGenerator gen = new EntityGenerator(dp,
                dc.getEntities().get(entityKeys.get(0)),
                Objects.requireNonNullElseGet(dc.getEntities().get(entityKeys.get(0)).getSeparator(), () -> dc.getDefaultConfig().getSeparator()));
        Iterator<String> iterator = Util.newBufferedReader(dp).lines().skip(1).iterator();

        String tmp = "insert $e isa entity1, has entity1-id \"entity1id0\", has entity1-name \"entity1name0\", has entity1-exp \"entity1id0exp0\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id1\", has entity1-name \"entity1name1\", has entity1-exp \"entity1id1exp11\", has entity1-exp \"entity1id1exp12\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id2\", has entity1-name \"entity1name2\", has entity1-exp \"entity1id2exp21\", has entity1-exp \"entity1id2exp22\", has entity1-exp \"entity1id2exp23\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id3\", has entity1-name \"entity1name3\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id4\", has entity1-name \"entity1name4\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id5\", has entity1-name \"entity1name5\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id6\", has entity1-name \"entity1name6\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id7\", has entity1-name \"entity1name7\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id8\", has entity1-name \"entity1name8\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id9\", has entity1-name \"entity1name9\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id10\", has entity1-name \"entity1name10\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id11\", has entity1-name \"entity1name11\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id12\", has entity1-name \"entity1name12\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id13\", has entity1-name \"entity1name13\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id14\", has entity1-name \"entity1name14\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id15\", has entity1-name \"entity1name15\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id16\", has entity1-name \"entity1name16\", has entity1-name \"entity1name16-2\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id17\", has entity1-name \"entity1name17\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id18\", has entity1-name \"entity1name18\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity1, has entity1-id \"entity1id19\", has entity1-name \"entity1name19\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());


        dp = new File("src/test/resources/1.0.0/generic/entity2.tsv").getAbsolutePath();
        gen = new EntityGenerator(dp, dc.getEntities().get(entityKeys.get(1)),
                Objects.requireNonNullElseGet(dc.getEntities().get(entityKeys.get(1)).getSeparator(), () -> dc.getDefaultConfig().getSeparator()));
        iterator = Util.newBufferedReader(dp).lines().skip(1).iterator();

        tmp = "insert $e isa entity2, has entity2-id \"entity2id0\", has entity2-bool true, has entity2-double 0.0;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id1\", has entity2-bool false, has entity2-double 1.1, has entity2-double 11.11;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id2\", has entity2-bool true, has entity2-double 2.2;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id3\", has entity2-bool false, has entity2-double -3.3;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id4\", has entity2-double 4.0;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id5\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id6\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id7\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id8\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id9\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity2, has entity2-id \"entity2id10\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());


        dp = new File("src/test/resources/1.0.0/generic/entity3.tsv").getAbsolutePath();
        gen = new EntityGenerator(dp, dc.getEntities().get(entityKeys.get(2)),
                Objects.requireNonNullElseGet(dc.getEntities().get(entityKeys.get(2)).getSeparator(), () -> dc.getDefaultConfig().getSeparator()));
        iterator = Util.newBufferedReader(dp).lines().skip(1).iterator();

        tmp = "insert $e isa entity3, has entity3-id \"entity3id0\", has entity3-int 0;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id1\", has entity3-int 1, has entity3-int 11;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id2\", has entity3-int 2;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id3\", has entity3-int -3;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id4\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id5\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id6\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id7\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id8\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id9\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());

        tmp = "insert $e isa entity3, has entity3-id \"entity3id10\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseTSV(iterator.next())).toString());
    }

    @Test
    public void phoneCallsPersonTest() throws IOException {
        String dbName = "entity-generator-test";
        String sp = new File("src/test/resources/1.0.0/phoneCalls/schema.gql").getAbsolutePath();
        TypeDBClient client = GraknUtil.getClient("localhost:1729");
        GraknUtil.cleanAndDefineSchemaToDatabase(client, dbName, sp);

        String dp = new File("src/test/resources/1.0.0/phoneCalls/person.csv").getAbsolutePath();
        String dcp = new File("src/test/resources/1.0.0/phoneCalls/dc.json").getAbsolutePath();
        Configuration dc = Util.initializeDataConfig(dcp);
        assert dc != null;
        String entityKey = "person";
        TypeDBSession session = GraknUtil.getDataSession(client, dbName);
        for (int idx = 0; idx < dc.getEntities().get(entityKey).getAttributes().length; idx++) {
            setEntityHasAttributeConceptType(entityKey, idx, dc, session);
        }
        EntityGenerator gen = new EntityGenerator(dp,
                dc.getEntities().get(entityKey),
                Objects.requireNonNullElseGet(dc.getEntities().get(entityKey).getSeparator(), () -> dc.getDefaultConfig().getSeparator()));

        session.close();
        client.close();

        Iterator<String> iterator = Util.newBufferedReader(dp).lines().skip(1).iterator();

        String tmp = "insert $e isa person, has first-name \"Melli\", has last-name \"Winchcum\", has phone-number \"+7 171 898 0853\", has city \"London\", has age 55;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Celinda\", has last-name \"Bonick\", has phone-number \"+370 351 224 5176\", has city \"London\", has age 52;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Chryste\", has last-name \"Lilywhite\", has phone-number \"+81 308 988 7153\", has city \"London\", has age 66;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"D'arcy\", has last-name \"Byfford\", has phone-number \"+54 398 559 0423\", has city \"London\", has age 19, has nick-name \"D\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Xylina\", has last-name \"D'Alesco\", has phone-number \"+7 690 597 4443\", has city \"Cambridge\", has age 51;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Roldan\", has last-name \"Cometti\", has phone-number \"+263 498 495 0617\", has city \"Oxford\", has age 59, has nick-name \"Rolly\", has nick-name \"Rolli\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Cob\", has last-name \"Lafflin\", has phone-number \"+63 815 962 6097\", has city \"Cambridge\", has age 56;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Olag\", has last-name \"Heakey\", has phone-number \"+81 746 154 2598\", has city \"London\", has age 45;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Mandie\", has last-name \"Assender\", has phone-number \"+261 860 539 4754\", has city \"London\", has age 18;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Elenore\", has last-name \"Stokey\", has phone-number \"+62 107 530 7500\", has city \"Oxford\", has age 35;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+86 921 547 9004\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+48 894 777 5173\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+86 922 760 0418\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+33 614 339 0298\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+30 419 575 7546\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+7 414 625 3019\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+57 629 420 5680\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+351 515 605 7915\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+36 318 105 5629\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+63 808 497 1769\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+62 533 266 3426\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+351 272 414 6570\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+86 825 153 5518\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+86 202 257 8619\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+27 117 258 4149\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+48 697 447 6933\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+48 195 624 2025\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+1 254 875 4647\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+7 552 196 4096\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has phone-number \"+86 892 682 0628\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"John\", has last-name \"Smith\", has phone-number \"+62 999 888 7777\", has city \"London\", has age 43, has nick-name \"Jack\", has nick-name \"J\";";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        tmp = "insert $e isa person, has first-name \"Jane\", has last-name \"Smith\", has phone-number \"+62 999 888 7778\", has city \"London\", has age 43;";
        Assert.assertEquals(tmp, gen.generateInsertStatement(Util.parseCSV(iterator.next())).toString());

        try {
            gen.generateInsertStatement(Util.parseCSV(iterator.next()));
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            Assert.assertEquals("Index 0 out of bounds for length 0", indexOutOfBoundsException.getMessage());
        }

        try {
            gen.generateInsertStatement(Util.parseCSV(iterator.next()));
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            Assert.assertEquals("Index 0 out of bounds for length 0", indexOutOfBoundsException.getMessage());
        }

        try {
            gen.generateInsertStatement(Util.parseCSV(iterator.next()));
        } catch (IndexOutOfBoundsException indexOutOfBoundsException) {
            Assert.assertEquals("Index 0 out of bounds for length 0", indexOutOfBoundsException.getMessage());
        }
    }

    private void setEntityHasAttributeConceptType(String entityKey, int attributeIndex, Configuration dc, TypeDBSession session) {
        dc.getEntities().get(entityKey).getAttributes()[attributeIndex].setConceptValueType(session.transaction(TypeDBTransaction.Type.READ));
    }
}

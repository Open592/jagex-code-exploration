package com.jagex.client;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.jagex.client.env.ModeGame;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

// Regression for 95e6468: original 592 qh.a(ZLrs;Z)V excludes RuneScape Attack
// from the general pass (bytecode 225-252), then adds it with combat priority.
class NpcMenuTest {
  @BeforeEach
  void resetMenu() {
    Static206.A_LINKED_LIST___28.clear();
    Static407.anInt6710 = 0;
    Static234.aBoolean411 = false;
    Static341.aBoolean599 = false;
    ClientSettings.modeGame = ModeGame.RUNESCAPE;
    ClientSettings.langID = 0;
    Static1.aClass16_Sub1_Sub5_Sub1_1 = new Class16_Sub1_Sub5_Sub1();
    Static1.aClass16_Sub1_Sub5_Sub1_1.anInt4345 = 62;
  }

  private Class16_Sub1_Sub5_Sub2 npc(String name, int level, int slot) {
    NpcType type = new NpcType();
    type.name = name;
    type.lb = level;
    type.ops[1] = "Attack";
    Class16_Sub1_Sub5_Sub2 npc = new Class16_Sub1_Sub5_Sub2();
    npc.aNpc_Type_1 = type;
    npc.anInt6037 = slot;
    return npc;
  }

  private List<Node_Sub39> entries(String option) {
    List<Node_Sub39> result = new ArrayList<>();
    for (Node_Sub39 entry = (Node_Sub39) Static206.A_LINKED_LIST___28.head();
        entry != null;
        entry = (Node_Sub39) Static206.A_LINKED_LIST___28.next()) {
      if (entry.aString55.equals(option)) {
        result.add(entry);
      }
    }
    return result;
  }

  @Test
  void reportedNpcsHaveOneAttackPerEntity() {
    Static325.method4396(false, npc("Black Knight", 33, 101));
    Static325.method4396(false, npc("Giant rat", 6, 102));
    Static325.method4396(false, npc("Imp", 2, 103));
    assertEquals(3, entries("Attack").size());
    assertEquals(3, entries("Examine").size());
    for (Node_Sub39 entry : entries("Attack")) {
      assertEquals(15, entry.anInt5699);
    }
  }

  @Test
  void strongerNpcRetainsRightClickAttackPriorityAndOtherOptions() {
    Class16_Sub1_Sub5_Sub2 npc = npc("Black Knight", 33, 101);
    npc.aNpc_Type_1.ops[0] = "Talk-to";
    Static1.aClass16_Sub1_Sub5_Sub1_1.anInt4345 = 3;
    Static325.method4396(false, npc);
    assertEquals(1, entries("Attack").size());
    assertEquals(2015, entries("Attack").get(0).anInt5699);
    assertEquals(1, entries("Talk-to").size());
  }

  @Test
  void otherGameModeAlsoHasOneAttack() {
    ClientSettings.modeGame = ModeGame.STELLAR_DAWN;
    Static325.method4396(false, npc("Black Knight", 33, 101));
    assertEquals(1, entries("Attack").size());
  }

  @Test
  void twoActualEntitiesRetainDistinctTargets() {
    Static325.method4396(false, npc("Black Knight", 33, 101));
    Static325.method4396(false, npc("Black Knight", 33, 102));
    assertEquals(2, entries("Attack").size());
    assertEquals(2, entries("Attack").stream().map(entry -> entry.aLong192).distinct().count());
  }
}

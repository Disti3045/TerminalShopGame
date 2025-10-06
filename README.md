# 🏺TerminalShopGame
> *“La prima luce filtra tra le persiane, accendendo di riflessi dorati le bottiglie e i metalli.  
> Le strade ancora vuote si destano piano, e una chiave gira nella serratura…”*

In questo gioco vestirai i panni di un **bottegaio** in una città antica e misteriosa, dove ogni giorno
devi bilanciare **profitto, reputazione e moralità**.

Apri la tua bottega, servi i clienti, commercia oggetti magici e decidi come comportarti
con i **ricercati** che tentano di confondersi tra la folla.

Ogni scelta ha un peso.  
Ogni vendita è un rischio.  
Ogni moneta racconta una storia.

---

## 🌅 Descrizione del Gioco

Nel cuore di una città fantasy, le strade si animano al sorgere del sole.  
Tu sei il **bottegaio**, erede di una piccola attività che vende oggetti magici e rari.

Ogni giorno:
- Apri la tua bottega.
- Controlla il tuo inventario.
- Accogli una serie di clienti casuali.
- Decidi se vendere, rifiutare o affrontare chi ha il volto su un manifesto di taglia.

Tra affari onesti e intrighi pericolosi, la tua reputazione e le tue scorte determineranno
quanto a lungo potrai restare aperto.

> “Le mani scorrono sulle merci, contando, pesando, ricordando.  
> Ogni oggetto sembra avere una storia da sussurrare nella penombra dell’alba.”

---

## 🎯 Obiettivo

Il tuo scopo è **sopravvivere e prosperare** come mercante.

Dovrai:
- Vendere oggetti ai clienti.
- Gestire il tuo inventario.
- Affrontare i ricercati.
- Comprare nuove scorte al porto.
- Mantenere alta la tua reputazione.

---

## 🧾 Inventario

All’inizio di ogni giornata visualizzerai il contenuto della tua bottega:

| Oggetto | Descrizione | Prezzo base |
|----------|--------------|-------------|
| 🧪 `healthFlask` | Pozione curativa, molto richiesta | 7$ |
| 💪 `strengthPotion` | Elisir di forza, valore medio | 8$ |
| ⚡ `speedTalisman` | Talismano di velocità, alto valore | 10$ |
| ☠️ `poisonusAmulet` | Amuleto velenoso, raro e pericoloso | 2$ |

- Ogni oggetto ha **una quantità limitata** (`numeroOggetti`) e **uno stock massimo** (`stack`).
- Quando le scorte finiscono, dovrai recarti al **porto** per rifornirti.

---

## 💰 Giornata di Lavoro

Ogni giornata di gioco si compone di diverse fasi:

1. **Apertura del negozio** — Descrizione narrativa e controllo dell’inventario.  
2. **Lista dei ricercati** — Alcuni NPC della città avranno una **taglia** sulla testa.  
3. **Arrivo dei clienti** — Circa 15 clienti casuali visiteranno la bottega.  
4. **Interazione** — Ogni cliente può richiedere un oggetto specifico, e tu puoi:
   - **(1)** Vendere normalmente.
   - **(2)** Rifiutare la vendita (perderai reputazione).
   - **(3)** *(Solo se è un ricercato)* Offrire un **poisonusAmulet** e riscuotere la taglia.
5. **Chiusura** — Resoconto giornaliero e possibilità di continuare o terminare la partita.

---

## ⚖️ Reputazione

La **reputazione** è un valore chiave nel gioco.  
Influenza:
- Il prezzo di acquisto delle merci al porto.  
- Il comportamento dei clienti.  
- Le tue opportunità future.

| Azione | Effetto sulla reputazione |
|--------|-----------------------------|
| Vendita riuscita | +0 (stabile) |
| Mancanza di scorte / rifiuto cliente | −1 / −2 |
| Tradimento di un ricercato | −1 |
| Consegna riuscita di un ricercato (con amuleto) | +0 (ma guadagni taglia) |

Più alta è la tua reputazione, **più basso sarà il costo delle scorte** al porto.

---

## ⚓ Il Porto e il Rifornimento

Alla fine di ogni giornata puoi visitare il porto per acquistare nuove scorte.  
Le acque scure riflettono le luci delle lanterne, e un mercante misterioso ti attende.

Puoi scegliere:
1. **Full** — Riempire completamente lo stock.  
2. **Metà** — Acquistare metà scorte.  
3. **Nessuna** — Non comprare nulla (rischioso, ma economico).

Il **prezzo dinamico** delle scorte varia in base alla reputazione del mercante:
più sei stimato, meno pagherai.

---

## 🌙 Fine della Giornata

Al tramonto, riceverai un **resoconto** della giornata:

- 💰 Monete guadagnate  
- 📦 Scorte vendute  
- 🎯 Ricercati sistemati  
- ⚖️ Reputazione attuale  

> “Le ultime monete tintinnano nel baule, la porta si chiude con un suono familiare.  
> Fuori, il cielo si tinge d’ambra mentre il mondo rallenta e tace.”

Dopodiché potrai decidere:
- **Continuare** al giorno successivo.  
- **Chiudere** la partita, conservando il tuo onore e le tue monete.

---

## 💡 Consigli del Mercante

- Mantieni sempre almeno **una scorta di ogni tipo**.  
- Tratta con i ricercati con cautela: le taglie sono ricche, ma rischiose.  
- Controlla la tua reputazione: influisce su tutto, dai prezzi alle opportunità.  
- Pianifica i tuoi acquisti: spendi meno quando la reputazione è alta.  
- Ricorda: **l’equilibrio tra avidità e prudenza** è la chiave per sopravvivere.

---

##Guida all'istallazione

1. Aprire un nuovo progetto Java.
2. Scaricare la cartella 'src' e sostituirla a quella presente nel nuovo progetto Java.
3. Eseguire il codice main.java e scrivere sul terminale.

---

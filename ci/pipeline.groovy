println "Hello World!"
println "Hello World 222222!"


def sh(command) {
    def command = "echo ${env}"
    def proc = command.execute()
    proc.waitFor()              

    println "Process exit code: ${proc.exitValue()}"
    println "Std Err: ${proc.err.text}"
    println "Std Out: ${proc.in.text}"
}


sh "echo ${env}"

sh "echo ${script.env}"